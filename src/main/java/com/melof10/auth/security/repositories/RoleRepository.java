package com.melof10.auth.security.repositories;

import com.melof10.auth.security.entities.Role;
import com.melof10.auth.security.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleName roleName);
}
