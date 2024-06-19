package com.pragma.microservice2.adapters.driving.http.controller;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddOrderRequest;
import com.pragma.microservice2.adapters.driving.http.dto.response.OrderToClientResponse;
import com.pragma.microservice2.adapters.driving.http.dto.response.OrderToEmployeeResponse;
import com.pragma.microservice2.adapters.driving.http.mapper.IOrderRequestMapper;
import com.pragma.microservice2.adapters.driving.http.mapper.IOrderResponseMapper;
import com.pragma.microservice2.domain.api.IOrderServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class IOrderRestControllerAdapter {

    private final IOrderServicePort orderServicePort;

    private final IOrderRequestMapper orderRequestMapper;
    private final IOrderResponseMapper orderResponseMapper;


    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping("/")
    public ResponseEntity<OrderToClientResponse> addOrder(@Valid @RequestBody AddOrderRequest request){
        return ResponseEntity.ok(orderResponseMapper.toOrderResponse(
                orderServicePort.saveOrder(orderServicePort.saveOrder(orderRequestMapper.addRequestToOrder(request)))));
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/")
    public ResponseEntity<List<OrderToEmployeeResponse>> getOrders(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "all") String status){
        return ResponseEntity.ok(orderResponseMapper.toOrderResponseList(orderServicePort.getAllOrders(page, size, status)));
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @PatchMapping("/")
    public ResponseEntity<Void> setStatusOrder(
            @RequestParam Long idOrder,
            @RequestParam(defaultValue = "") String code){
        orderServicePort.patchOrderStatus(idOrder, code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
