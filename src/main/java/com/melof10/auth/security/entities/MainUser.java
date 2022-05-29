package com.melof10.auth.security.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MainUser implements UserDetails {

    private String fullname;

    private String email;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public MainUser(String fullname, String email, String username, String password,
                    Collection<? extends GrantedAuthority> authorities) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static MainUser build(User user) {
        List<GrantedAuthority> authorities =
                user.getRoles().stream().map(rol ->
                        new SimpleGrantedAuthority(rol.getRoleName().name())).collect(Collectors.toList());

        return new MainUser(user.getFullname(), user.getEmail(), user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }
}
