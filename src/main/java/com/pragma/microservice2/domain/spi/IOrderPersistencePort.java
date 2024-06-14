package com.pragma.microservice2.domain.spi;

import com.pragma.microservice2.domain.model.Order;

public interface IOrderPersistencePort {
    Order saveOrder(Order order);
}
