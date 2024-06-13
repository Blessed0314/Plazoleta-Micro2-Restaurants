package com.pragma.microservice2.adapters.driven.jpa.mysql.repository;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, String>{
    Boolean existsByName(String name);
    Page<RestaurantEntity> findAll(Pageable pageable);
}
