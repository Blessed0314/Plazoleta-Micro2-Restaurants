package com.pragma.microservice2.adapters.driven.jpa.mysql.services;

import com.pragma.microservice2.adapters.driving.http.controller.IFeignUserDataToSmsController;
import com.pragma.microservice2.adapters.driving.http.dto.response.UserToSmsResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService {
    private final IFeignUserDataToSmsController feignUserDataToSmsController;

    public UserToSmsResponse getUserToSmsData(String dni){
        return feignUserDataToSmsController.getSmsData(dni);
    }
}
