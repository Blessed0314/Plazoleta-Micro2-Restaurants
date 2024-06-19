package com.pragma.microservice2.adapters.driving.http.FeignClient.services;

import com.pragma.microservice2.adapters.driving.http.FeignClient.client.SmsFeignClient;
import com.pragma.microservice2.adapters.driving.http.dto.response.UserToSmsResponse;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    private final SmsFeignClient smsFeignClient;

    public SmsService(SmsFeignClient smsFeignClient) {
        this.smsFeignClient = smsFeignClient;
    }

    public void sendSms(UserToSmsResponse userToSmsResponse){
        smsFeignClient.sendSms(userToSmsResponse);
    }
}
