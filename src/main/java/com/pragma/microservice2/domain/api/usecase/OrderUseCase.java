package com.pragma.microservice2.domain.api.usecase;

import com.pragma.microservice2.domain.api.IOrderServicePort;
import com.pragma.microservice2.domain.model.Order;
import com.pragma.microservice2.domain.spi.IOrderPersistencePort;

import java.util.List;

public class OrderUseCase implements IOrderServicePort {

    private final IOrderPersistencePort orderPersistencePort;

    public OrderUseCase(IOrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderPersistencePort.saveOrder(order);
    }

    @Override
    public List<Order> getAllOrders(Integer page, Integer size, String status) {
        return orderPersistencePort.getAllOrders(page, size, status);
    }

    @Override
    public void patchOrderStatus(Long id) {
        orderPersistencePort.patchOrderStatus(id);
    }
}
