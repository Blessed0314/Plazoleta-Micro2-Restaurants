package com.pragma.microservice2.domain.api.usecase;

import com.pragma.microservice2.domain.api.IOrderItemServicePort;
import com.pragma.microservice2.domain.model.OrderItem;
import com.pragma.microservice2.domain.spi.IOrderItemPersistencePort;

import java.util.List;

public class OrderItemUseCase implements IOrderItemServicePort {

    private final IOrderItemPersistencePort orderItemPersistencePort;

    public OrderItemUseCase(IOrderItemPersistencePort orderItemPersistencePort) {
        this.orderItemPersistencePort = orderItemPersistencePort;
    }

    @Override
    public void saveOrderItems(List<OrderItem> orderItems, Long orderId) {
        orderItemPersistencePort.saveOrderItems(orderItems, orderId);
    }
}
