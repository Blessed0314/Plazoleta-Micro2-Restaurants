package com.pragma.microservice2.adapters.driven.jpa.mysql.repository;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long>{
    Optional<OrderEntity> findByDniClientAndStatus(String dniClient, String status);
}
