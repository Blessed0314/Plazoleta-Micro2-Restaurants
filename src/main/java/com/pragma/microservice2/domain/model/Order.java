package com.pragma.microservice2.domain.model;

import java.util.List;

public class Order {
     private final Long id;
     private final String dniClient;
     private final Restaurant restaurant;
     private List<OrderItem> orderItems;
     private final String status;


    public Order(Long id, String dniClient, Restaurant restaurant, List<OrderItem> orderItems, String status) {
        this.id = id;
        this.dniClient = dniClient;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getDniClient() {
        return dniClient;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
