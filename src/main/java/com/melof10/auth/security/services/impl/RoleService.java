package com.melof10.auth.security.services.impl;

import com.melof10.auth.security.entities.Role;
import com.melof10.auth.security.enums.RoleName;
import com.melof10.auth.security.repositories.RoleRepository;
import com.melof10.auth.security.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
