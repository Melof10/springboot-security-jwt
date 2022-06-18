package com.melof10.auth.security.dto;

import javax.validation.constraints.NotNull;

public class JwtDTO {

    @NotNull(message = "Token required")
    private String token;

    public JwtDTO() {

    }

    public JwtDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
