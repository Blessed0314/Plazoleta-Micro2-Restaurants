package com.pragma.microservice2.adapters.driven.jpa.mysql.adapter;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderItemEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.OrderNotFoundException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.IOrderItemEntityMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IOrderItemRepository;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IOrderRepository;
import com.pragma.microservice2.domain.model.OrderItem;
import com.pragma.microservice2.domain.spi.IOrderItemPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderItemAdapter implements IOrderItemPersistencePort {

    private final IOrderItemRepository orderItemRepository;
    private final IOrderRepository orderRepository;
    private final IOrderItemEntityMapper orderItemEntityMapper;

    @Override
    public void saveOrderItems(List<OrderItem> orderItems, Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        for (OrderItem orderItem : orderItems) {
            Optional<OrderItemEntity> orderItemOptional = orderItemRepository.findByDishId(orderItem.getDish().getId());
            if (orderItemOptional.isEmpty()) {
                saveOrderItem(orderItemEntityMapper.toEntity(orderItem), orderEntity);
            } else {
                OrderItemEntity existingOrderItemEntity = orderItemOptional.get();
                existingOrderItemEntity.setQuantity(existingOrderItemEntity.getQuantity() + orderItem.getQuantity());
                saveOrderItem(existingOrderItemEntity, orderEntity);
            }
        }
    }

    private void saveOrderItem(OrderItemEntity orderItemEntity, OrderEntity orderEntity){
        System.out.println(orderEntity.getId());
        orderItemEntity.setOrder(orderEntity);
        System.out.println(orderItemEntity.getOrder().getId());
        orderItemRepository.save(orderItemEntity);
    }
}
