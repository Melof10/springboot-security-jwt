package com.melof10.auth.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class NewUserDTO {

    @NotNull(message = "Fullname required")
    private String fullname;

    @NotNull(message = "Email required")
    @Email(message = "Email invalid")
    private String email;

    @NotNull(message = "Username required")
    private String username;

    @NotBlank(message = "Password required")
    private String password;

    @NotNull(message = "Roles required")
    private Set<String> roles = new HashSet<>();

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
