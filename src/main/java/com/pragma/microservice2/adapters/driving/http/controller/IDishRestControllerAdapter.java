package com.pragma.microservice2.adapters.driving.http.controller;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddDishRequest;
import com.pragma.microservice2.adapters.driving.http.dto.request.UpdateDishRequest;
import com.pragma.microservice2.adapters.driving.http.dto.response.DishResponse;
import com.pragma.microservice2.adapters.driving.http.mapper.IDishRequestMapper;
import com.pragma.microservice2.adapters.driving.http.mapper.IDishResponseMapper;
import com.pragma.microservice2.domain.api.IDishServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class IDishRestControllerAdapter {

    private final IDishServicePort dishServicePort;

    private final IDishResponseMapper dishResponseMapper;
    private final IDishRequestMapper dishRequestMapper;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/")
    public ResponseEntity<Void> addDish(@Valid @RequestBody AddDishRequest request){
        dishServicePort.saveDish(dishRequestMapper.addRequestToDish(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasRole('OWNER')")
    @PutMapping("/")
    public ResponseEntity<DishResponse> updateDish(@Valid @RequestBody UpdateDishRequest request){
        return ResponseEntity.ok(dishResponseMapper.toDishResponse(dishServicePort.updateDish(dishRequestMapper.updateRequestToDish(request))));
    }

    @PreAuthorize("hasRole('OWNER')")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id){
        dishServicePort.patchIsActiveDish(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/")
    public ResponseEntity<List<DishResponse>> getDishList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "all") String category){
        return ResponseEntity.ok(dishResponseMapper.toDishResponseList(dishServicePort.getAllDishes(page, size, category)));
    }
}
