package com.pragma.microservice2.adapters.driving.http.FeignClient.services;

import com.pragma.microservice2.adapters.driving.http.FeignClient.client.UserFeignClient;
import com.pragma.microservice2.adapters.driving.http.dto.response.UserToSmsResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public UserToSmsResponse getUserToSmsData(String dni){
        return userFeignClient.getSmsData(dni);
    }
}
