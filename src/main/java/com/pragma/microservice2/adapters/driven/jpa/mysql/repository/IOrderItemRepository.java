package com.pragma.microservice2.adapters.driven.jpa.mysql.repository;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOrderItemRepository extends JpaRepository<OrderItemEntity, Long>{
    Optional<OrderItemEntity> findByDishId(Long dishId);
}
