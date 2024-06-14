package com.pragma.microservice2.adapters.driven.jpa.mysql.adapter;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderItemEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.HaveOrderInProgressException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.IOrderEntityMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.IOrderItemEntityMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IOrderItemRepository;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IOrderRepository;
import com.pragma.microservice2.adapters.security.CustomUserDetail;
import com.pragma.microservice2.domain.model.Order;
import com.pragma.microservice2.domain.model.OrderItem;
import com.pragma.microservice2.domain.spi.IOrderPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderAdapter implements IOrderPersistencePort {

    private final IOrderRepository orderRepository;
    private final IOrderEntityMapper orderEntityMapper;

    private final IOrderItemRepository orderItemRepository;
    private final IOrderItemEntityMapper orderItemEntityMapper;

    @Override
    public Order saveOrder(Order order) {
        Optional<OrderEntity> orderEntityOptional = orderRepository.findByDniClientAndStatus(order.getDniClient(), "IN PROGRESS");
        if (orderEntityOptional.isPresent()) {
            throw new HaveOrderInProgressException();
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OrderEntity orderEntity = orderEntityMapper.toEntity(order);
        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDetail userDetails){
            orderEntity.setDniClient(userDetails.getDni());
            orderEntity.setStatus("PENDING");
        }

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
}
