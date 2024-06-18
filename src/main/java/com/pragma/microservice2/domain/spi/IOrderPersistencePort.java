package com.pragma.microservice2.domain.spi;

import com.pragma.microservice2.domain.model.Order;

import java.util.List;

public interface IOrderPersistencePort {
    Order saveOrder(Order order);
    List<Order> getAllOrders(Integer page, Integer size, String status);
    void patchOrderStatus(Long id);
}
