package com.pragma.microservice2.domain.api;

import com.pragma.microservice2.domain.model.Order;

public interface IOrderServicePort {
    Order saveOrder(Order order);
}
