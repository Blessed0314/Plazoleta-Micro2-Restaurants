package com.pragma.microservice2.adapters.driving.http.controller;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddRestaurantRequest;
import com.pragma.microservice2.adapters.driving.http.mapper.IRestaurantRequestMapper;
import com.pragma.microservice2.domain.api.IRestaurantServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class IRestaurantRestControllerAdapter {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/")
    public ResponseEntity<Void> addRestaurant(@Valid @RequestBody AddRestaurantRequest request){
        restaurantServicePort.saveRestaurant(restaurantRequestMapper.addRequestToRestaurant(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
