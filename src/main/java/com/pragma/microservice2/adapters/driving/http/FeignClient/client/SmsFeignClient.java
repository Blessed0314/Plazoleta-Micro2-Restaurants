package com.pragma.microservice2.adapters.driving.http.FeignClient.client;

import com.pragma.microservice2.adapters.driving.http.FeignClient.config.FeignClientConfig;
import com.pragma.microservice2.adapters.driving.http.dto.response.UserToSmsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sms-service-client", url = "http://localhost:8092", configuration = FeignClientConfig.class)
public interface SmsFeignClient {
    @PostMapping(value = "/sms/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    void sendSms(@RequestBody UserToSmsResponse userToSmsResponse);

}
