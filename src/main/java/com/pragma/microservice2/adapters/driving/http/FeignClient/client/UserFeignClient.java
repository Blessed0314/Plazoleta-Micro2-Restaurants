package com.pragma.microservice2.adapters.driving.http.FeignClient.client;

import com.pragma.microservice2.adapters.driving.http.FeignClient.config.FeignClientConfig;
import com.pragma.microservice2.adapters.driving.http.dto.response.UserToSmsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service-client", url = "http://localhost:8090", configuration = FeignClientConfig.class)
public interface UserFeignClient {

    @GetMapping(value = "/user/sms", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserToSmsResponse getSmsData(@RequestParam("dni") String dni);
}
