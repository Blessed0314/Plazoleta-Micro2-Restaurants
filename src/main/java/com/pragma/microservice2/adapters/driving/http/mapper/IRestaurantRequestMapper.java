package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddRestaurantRequest;
import com.pragma.microservice2.domain.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRestaurantRequestMapper {
    Restaurant addRequestToRestaurant(AddRestaurantRequest addRestaurantRequest);
}
