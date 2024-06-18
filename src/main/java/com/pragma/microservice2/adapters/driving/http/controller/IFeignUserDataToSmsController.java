package com.pragma.microservice2.adapters.driving.http.controller;

import com.pragma.microservice2.adapters.driving.http.dto.response.UserToSmsResponse;
import com.pragma.microservice2.configuration.client.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sms-service", url = "http://localhost:8090", configuration = FeignClientConfig.class)
public interface IFeignUserDataToSmsController {

    @GetMapping(value = "/user/sms", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserToSmsResponse getSmsData(@RequestParam("dni") String dni);
}
