package com.pragma.microservice2.domain.api.usecase;

import com.pragma.microservice2.domain.api.IOrderServicePort;
import com.pragma.microservice2.domain.model.Order;
import com.pragma.microservice2.domain.spi.IOrderPersistencePort;

public class OrderUseCase implements IOrderServicePort {

    private final IOrderPersistencePort orderPersistencePort;

    public OrderUseCase(IOrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderPersistencePort.saveOrder(order);
    }
}
