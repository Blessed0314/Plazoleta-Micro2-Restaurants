package com.pragma.microservice2.adapters.driven.jpa.mysql.mapper;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.*;
import com.pragma.microservice2.domain.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ManualMapper {

    public Order toModel(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }

        return new Order(
                orderEntity.getId(),
                orderEntity.getDniClient(),
                toModel(orderEntity.getRestaurant()),
                orderEntity.getOrderItems().stream()
                        .map(this::toModel)
                        .collect(Collectors.toList()),
                orderEntity.getStatus()
        );
    }

    public OrderItem toModel(OrderItemEntity orderItemEntity) {
        if (orderItemEntity == null) {
            return null;
        }

        return new OrderItem(
                orderItemEntity.getId(),
                toModel(orderItemEntity.getDish()),
                orderItemEntity.getQuantity(),
                null
        );
    }

    public Dish toModel(DishEntity dishEntity) {
        if (dishEntity == null) {
            return null;
        }

        return new Dish(
                dishEntity.getId(),
                dishEntity.getName(),
                dishEntity.getPrice(),
                dishEntity.getDescription(),
                dishEntity.getImage(),
                dishEntity.getCategory(),
                toModel(dishEntity.getRestaurant())
        );
    }

    public Restaurant toModel(RestaurantEntity restaurantEntity) {
        if (restaurantEntity == null) {
            return null;
        }

        return new Restaurant(
                restaurantEntity.getName(),
                restaurantEntity.getNit(),
                restaurantEntity.getAddress(),
                restaurantEntity.getPhone(),
                restaurantEntity.getLogo(),
                restaurantEntity.getDniOwner()
        );
    }

    public OrderEntity toEntity(Order order) {
        if (order == null) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setDniClient(order.getDniClient());
        orderEntity.setRestaurant(toEntity(order.getRestaurant()));
        orderEntity.setStatus(order.getStatus());
        orderEntity.setOrderItems(order.getOrderItems().stream()
                .map(this::toEntity)
                .collect(Collectors.toList()));

        return orderEntity;
    }

    public OrderItemEntity toEntity(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(orderItem.getId());
        orderItemEntity.setDish(toEntity(orderItem.getDish()));
        // Avoid setting order to prevent recursion
        orderItemEntity.setQuantity(orderItem.getQuantity());

        return orderItemEntity;
    }

    public DishEntity toEntity(Dish dish) {
        if (dish == null) {
            return null;
        }

        DishEntity dishEntity = new DishEntity();
        dishEntity.setId(dish.getId());
        dishEntity.setName(dish.getName());
        dishEntity.setPrice(dish.getPrice());
        dishEntity.setDescription(dish.getDescription());
        dishEntity.setImage(dish.getImage());
        dishEntity.setCategory(dish.getCategory());
        dishEntity.setRestaurant(toEntity(dish.getRestaurant()));

        return dishEntity;
    }

    public RestaurantEntity toEntity(Restaurant restaurant) {
        if (restaurant == null) {
            return null;
        }

        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setNit(restaurant.getNit());
        restaurantEntity.setName(restaurant.getName());
        restaurantEntity.setAddress(restaurant.getAddress());
        restaurantEntity.setPhone(restaurant.getPhone());
        restaurantEntity.setLogo(restaurant.getLogo());
        restaurantEntity.setDniOwner(restaurant.getDniOwner());

        return restaurantEntity;
    }
}
