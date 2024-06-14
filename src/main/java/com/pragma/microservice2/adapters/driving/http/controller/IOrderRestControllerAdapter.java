package com.pragma.microservice2.adapters.driving.http.controller;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddOrderRequest;
import com.pragma.microservice2.adapters.driving.http.dto.response.OrderResponse;
import com.pragma.microservice2.adapters.driving.http.mapper.IOrderItemRequestMapper;
import com.pragma.microservice2.adapters.driving.http.mapper.IOrderRequestMapper;
import com.pragma.microservice2.adapters.driving.http.mapper.IOrderResponseMapper;
import com.pragma.microservice2.domain.api.IOrderItemServicePort;
import com.pragma.microservice2.domain.api.IOrderServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class IOrderRestControllerAdapter {

    private final IOrderServicePort orderServicePort;
    private final IOrderItemServicePort orderItemServicePort;

    private final IOrderRequestMapper orderRequestMapper;
    private final IOrderResponseMapper orderResponseMapper;

    private final IOrderItemRequestMapper orderItemRequestMapper;

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping("/")
    public ResponseEntity<OrderResponse> addOrder(@Valid @RequestBody AddOrderRequest request){
        return ResponseEntity.ok(orderResponseMapper.toOrderResponse(
                orderServicePort.saveOrder(orderServicePort.saveOrder(orderRequestMapper.addRequestToOrder(request)))));
    }
}
