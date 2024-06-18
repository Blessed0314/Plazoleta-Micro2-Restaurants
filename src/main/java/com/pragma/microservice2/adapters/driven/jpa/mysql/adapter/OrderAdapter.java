package com.pragma.microservice2.adapters.driven.jpa.mysql.adapter;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderItemEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.HaveOrderInProgressException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.NullParametersException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.OrderNotFoundException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.WrongOrderException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.IOrderEntityMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.IOrderItemEntityMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.ManualMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IOrderItemRepository;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IOrderRepository;
import com.pragma.microservice2.adapters.driving.http.controller.IFeignUserDataToSmsController;
import com.pragma.microservice2.adapters.driving.http.dto.response.UserToSmsResponse;
import com.pragma.microservice2.adapters.security.CustomUserDetail;
import com.pragma.microservice2.domain.model.Order;
import com.pragma.microservice2.domain.model.OrderItem;
import com.pragma.microservice2.domain.spi.IOrderPersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrderAdapter implements IOrderPersistencePort {

    private final IOrderRepository orderRepository;
    private final IOrderEntityMapper orderEntityMapper;

    private final IOrderItemRepository orderItemRepository;
    private final IOrderItemEntityMapper orderItemEntityMapper;

    private final ManualMapper manualMapper;

    @Override
    public Order saveOrder(Order order) {
        Optional<OrderEntity> orderEntityOptional = orderRepository.findByDniClientAndStatus(order.getDniClient(), "IN PROGRESS");
        if (orderEntityOptional.isPresent()) {
            throw new HaveOrderInProgressException();
        }

        OrderEntity orderEntity = orderEntityMapper.toEntity(order);

        orderEntity.setDniClient(getUser().getDni());
        orderEntity.setStatus("PENDING");

        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        Order savedOrder = orderEntityMapper.toModel(savedOrderEntity);

        if (order.getOrderItems() != null) {
            List<OrderItemEntity> orderItemEntities = orderItemEntityMapper.orderItemListToOrderItemEntityList(order.getOrderItems());
            for (OrderItemEntity orderItemEntity : orderItemEntities) {
                orderItemEntity.setOrder(savedOrderEntity);
            }
            List<OrderItem> orderItems = orderItemEntityMapper.orderItemEntityListToOrderItemList(orderItemRepository.saveAll(orderItemEntities));
            savedOrder.setOrderItems(orderItems);
        }
        return savedOrder;
    }

    @Override
    public List<Order> getAllOrders(Integer page, Integer size, String status) {
        Pageable pageable = PageRequest.of(page, size);
        CustomUserDetail employee = getUser();
        List<OrderEntity> orders = "all".equalsIgnoreCase(status)
                ?orderRepository.findByDniOwner(employee.getDniBoss(), pageable).getContent()
                :orderRepository.findByDniOwnerAndStatus(employee.getDniBoss(),status,pageable).getContent();

        return orders.stream()
                .map(manualMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void patchOrderStatus(Long id) {

        if(id == null){
            throw new NullParametersException("Id must be provided");
        }

        OrderEntity order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        CustomUserDetail employee = getUser();

        if(!employee.getDniBoss().equals(order.getRestaurant().getDniOwner())){
            throw new WrongOrderException();
        }

        if(order.getStatus().equals("PENDING")){
            order.setAssignedEmployee(employee.getDni());
            order.setStatus("IN PROGRESS");
        }

        orderRepository.save(order);
    }

    private CustomUserDetail getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (CustomUserDetail) authentication.getPrincipal();
    }
}
