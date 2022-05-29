package com.melof10.auth.security.services;

import com.melof10.auth.security.entities.Role;
import com.melof10.auth.security.enums.RoleName;

import java.util.Optional;

public interface IRoleService {

    Optional<Role> getByRoleName(RoleName roleName);
}
