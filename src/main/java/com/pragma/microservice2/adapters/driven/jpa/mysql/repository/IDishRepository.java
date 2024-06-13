package com.pragma.microservice2.adapters.driven.jpa.mysql.repository;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDishRepository extends JpaRepository<DishEntity, Long>{
    Boolean existsByName(String name);
    Optional<DishEntity> findByRestaurant_Name(String restaurantName);
}
