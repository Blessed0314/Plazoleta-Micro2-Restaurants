package com.pragma.microservice2.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserToSmsResponse {
    private String name;
    private String lastname;
    private String cellphone;
}
