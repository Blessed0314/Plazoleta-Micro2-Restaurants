package com.pragma.microservice2.adapters.client;

import com.pragma.microservice2.configuration.client.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8090", configuration = FeignClientConfig.class)
public interface UserClient {
    @GetMapping(value = "/user/getRoleName", consumes = MediaType.APPLICATION_JSON_VALUE)
    String getUserRoleName(@RequestParam("dni") String dni);
}
