package com.pragma.microservice2.adapters.driven.jpa.mysql.repository;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long>{
    Optional<OrderEntity> findByDniClientAndStatus(String dniClient, String status);

    @Query("SELECT o FROM OrderEntity o WHERE o.restaurant.dniOwner = :dniOwner")
    Page<OrderEntity> findByDniOwner(@Param("dniOwner") String dniOwner, Pageable pageable);

    @Query("SELECT o FROM OrderEntity o WHERE o.restaurant.dniOwner = :dniOwner AND o.status = :status")
    Page<OrderEntity> findByDniOwnerAndStatus(@Param("dniOwner") String dniOwner, @Param("status") String status, Pageable pageable);

}
