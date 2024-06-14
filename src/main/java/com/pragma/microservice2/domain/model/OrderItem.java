package com.pragma.microservice2.domain.model;

public class OrderItem {
    private final Long id;
    private final Dish dish;
    private final Integer quantity;
    private final Order order;

    public OrderItem(Long id, Dish dish, Integer quantity, Order order) {
        this.id = id;
        this.dish = dish;
        this.quantity = quantity;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public Dish getDish() {
        return dish;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Order getOrder() {
        return order;
    }
}
