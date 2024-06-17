package com.pragma.microservice2.configuration;

import com.pragma.microservice2.adapters.driven.jpa.mysql.adapter.DishAdapter;
import com.pragma.microservice2.adapters.driven.jpa.mysql.adapter.OrderAdapter;
import com.pragma.microservice2.adapters.driven.jpa.mysql.adapter.OrderItemAdapter;
import com.pragma.microservice2.adapters.driven.jpa.mysql.adapter.RestaurantAdapter;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.*;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IDishRepository;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IOrderItemRepository;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IOrderRepository;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IRestaurantRepository;
import com.pragma.microservice2.domain.api.IDishServicePort;
import com.pragma.microservice2.domain.api.IOrderItemServicePort;
import com.pragma.microservice2.domain.api.IOrderServicePort;
import com.pragma.microservice2.domain.api.IRestaurantServicePort;
import com.pragma.microservice2.domain.api.usecase.DishUseCase;
import com.pragma.microservice2.domain.api.usecase.OrderItemUseCase;
import com.pragma.microservice2.domain.api.usecase.OrderUseCase;
import com.pragma.microservice2.domain.api.usecase.RestaurantUseCase;
import com.pragma.microservice2.domain.spi.IDishPersistencePort;
import com.pragma.microservice2.domain.spi.IOrderItemPersistencePort;
import com.pragma.microservice2.domain.spi.IOrderPersistencePort;
import com.pragma.microservice2.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    private final IOrderItemRepository orderItemRepository;
    private final IOrderItemEntityMapper orderItemEntityMapper;

    private final IOrderRepository orderRepository;
    private final IOrderEntityMapper orderEntityMapper;

    private final ManualMapper manualMapper;

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantAdapter(restaurantRepository, restaurantEntityMapper);
    }
    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort());
    }

    @Bean
    public IDishPersistencePort dishPersistencePort() {
        return new DishAdapter(dishRepository, restaurantRepository ,dishEntityMapper);
    }
    @Bean
    public IDishServicePort dishServicePort() {
        return new DishUseCase(dishPersistencePort());
    }

    @Bean
    public IOrderItemPersistencePort orderItemPersistencePort() {
        return new OrderItemAdapter(orderItemRepository, orderRepository, orderItemEntityMapper);
    }
    @Bean
    public IOrderItemServicePort orderItemServicePort() {
        return new OrderItemUseCase(orderItemPersistencePort());
    }

    @Bean
    public IOrderPersistencePort orderPersistencePort() {
        return new OrderAdapter(orderRepository, orderEntityMapper, orderItemRepository, orderItemEntityMapper, manualMapper);
    }
    @Bean
    public IOrderServicePort orderServicePort() {
        return new OrderUseCase(orderPersistencePort());
    }

}
