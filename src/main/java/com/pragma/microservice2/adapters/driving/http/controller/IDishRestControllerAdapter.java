package com.pragma.microservice2.adapters.driving.http.controller;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddDishRequest;
import com.pragma.microservice2.adapters.driving.http.mapper.IDishRequestMapper;
import com.pragma.microservice2.domain.api.IDishServicePort;
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
@RequestMapping("/dish")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class IDishRestControllerAdapter {
    private final IDishServicePort dishServicePort;
    private final IDishRequestMapper dishRequestMapper;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/")
    public ResponseEntity<Void> addDish(@Valid @RequestBody AddDishRequest request){
        dishServicePort.saveDish(dishRequestMapper.addRequestToDish(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
