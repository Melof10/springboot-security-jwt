package com.melof10.auth.security.services;

import com.melof10.auth.security.entities.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> getByUsername(String username);

    Optional<User> getByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void save(User user);
}
