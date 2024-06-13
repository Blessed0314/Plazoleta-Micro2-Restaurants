package com.pragma.microservice2.adapters.driving.http.controller;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddRestaurantRequest;
import com.pragma.microservice2.adapters.driving.http.dto.response.RestaurantResponse;
import com.pragma.microservice2.adapters.driving.http.mapper.IRestaurantRequestMapper;
import com.pragma.microservice2.adapters.driving.http.mapper.IRestaurantResponseMapper;
import com.pragma.microservice2.domain.api.IRestaurantServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class IRestaurantRestControllerAdapter {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/")
    public ResponseEntity<Void> addRestaurant(@Valid @RequestBody AddRestaurantRequest request){
        restaurantServicePort.saveRestaurant(restaurantRequestMapper.addRequestToRestaurant(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "true") boolean ascendingFlag){
        return ResponseEntity.ok(restaurantResponseMapper.toRestaurantResponseList(restaurantServicePort.getAllRestaurants(page, size, ascendingFlag)));
    }
}
