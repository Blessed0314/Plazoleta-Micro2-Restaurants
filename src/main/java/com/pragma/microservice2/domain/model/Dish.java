package com.pragma.microservice2.domain.model;

public class Dish {

    private final Long id;
    private final String name;
    private final Double price;
    private final String description;
    private final String image;
    private final String category;
    private final Restaurant restaurant;

    public Dish(Long id, String name, Double price, String description, String image, String category, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
