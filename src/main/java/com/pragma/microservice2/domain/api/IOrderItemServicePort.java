package com.pragma.microservice2.domain.api;

import com.pragma.microservice2.domain.model.OrderItem;

import java.util.List;

public interface IOrderItemServicePort {
    void saveOrderItems(List<OrderItem> orderItems, Long orderId);
}
