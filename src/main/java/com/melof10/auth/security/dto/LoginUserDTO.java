package com.melof10.auth.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginUserDTO {

    @Email
    private String email;

    private String username;

    @NotBlank
    private String password;

    public LoginUserDTO(String email, String username, @NotBlank String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public LoginUserDTO() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
