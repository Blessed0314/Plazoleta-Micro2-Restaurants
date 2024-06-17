package com.pragma.microservice2.domain.api;

import com.pragma.microservice2.domain.model.Order;

import java.util.List;

public interface IOrderServicePort {
    Order saveOrder(Order order);
    List<Order> getAllOrders(Integer page, Integer size, String status);
}
