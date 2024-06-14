package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddOrderItemRequest;
import com.pragma.microservice2.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderItemRequestMapper {
    @Mapping(target = "id", ignore = true)
    OrderItem addRequestToOrderItem(AddOrderItemRequest addOrderItemRequest);

    List<OrderItem> addRequestsToOrderItems(List<AddOrderItemRequest> addOrderItemRequests);
}
