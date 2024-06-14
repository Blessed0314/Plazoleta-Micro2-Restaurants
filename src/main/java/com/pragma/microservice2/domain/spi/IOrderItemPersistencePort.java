package com.pragma.microservice2.domain.spi;

import com.pragma.microservice2.domain.model.OrderItem;

import java.util.List;

public interface IOrderItemPersistencePort {
    void saveOrderItems(List<OrderItem> orderItems, Long orderId);
}
