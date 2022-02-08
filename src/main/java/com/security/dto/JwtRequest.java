package com.security.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JwtRequest {
    String userName;
    String password;

    public JwtRequest() {
    }

    public JwtRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
