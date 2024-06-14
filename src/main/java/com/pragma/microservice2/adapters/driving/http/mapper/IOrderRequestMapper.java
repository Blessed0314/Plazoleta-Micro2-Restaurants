package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddOrderRequest;
import com.pragma.microservice2.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IOrderRequestMapper {
    @Mapping(target = "id", ignore = true)
    Order addRequestToOrder(AddOrderRequest request);
}
