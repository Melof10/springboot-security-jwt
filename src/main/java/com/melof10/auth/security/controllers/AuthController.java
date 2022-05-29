package com.melof10.auth.security.controllers;

import com.melof10.auth.security.services.IRoleService;
import com.melof10.auth.security.services.IUserService;
import com.melof10.auth.security.utils.Message;
import com.melof10.auth.security.dto.LoginUserDTO;
import com.melof10.auth.security.dto.JwtDTO;
import com.melof10.auth.security.dto.NewUserDTO;
import com.melof10.auth.security.entities.Role;
import com.melof10.auth.security.entities.User;
import com.melof10.auth.security.enums.RoleName;
import com.melof10.auth.security.services.impl.RoleService;
import com.melof10.auth.security.services.impl.UserService;
import com.melof10.auth.security.jwt.JwtReturnReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value ="/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private JwtReturnReq jwtReturnReq;

    private Authentication authentication;

    @PostMapping(value = "/register")
    public ResponseEntity<JwtDTO> register(@Valid @RequestBody NewUserDTO newUserDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Invalid fields or email"), HttpStatus.BAD_REQUEST);
        if(iUserService.existsByUsername(newUserDTO.getUsername()))
            return new ResponseEntity(new Message("Existing username"), HttpStatus.BAD_REQUEST);
        if(iUserService.existsByEmail(newUserDTO.getEmail()))
            return new ResponseEntity(new Message("Existing email"), HttpStatus.BAD_REQUEST);

        User user = new User(newUserDTO.getFullname(), newUserDTO.getEmail(), newUserDTO.getUsername(),
                passwordEncoder.encode(newUserDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(iRoleService.getByRoleName(RoleName.ROLE_USER).get());
        if(newUserDTO.getRoles().contains("admin"))
            roles.add(iRoleService.getByRoleName(RoleName.ROLE_ADMIN).get());
        user.setRoles(roles);
        iUserService.save(user);

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(newUserDTO.getUsername(), newUserDTO.getPassword()));
        JwtDTO jwtDTO = jwtReturnReq.getTokenRequest(authentication);

        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUserDTO loginUserDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Invalid fields or email"), HttpStatus.BAD_REQUEST);

        if(loginUserDTO.getUsername() != null)
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getUsername(), loginUserDTO.getPassword()));
        else
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(), loginUserDTO.getPassword()));

        JwtDTO jwtDTO = jwtReturnReq.getTokenRequest(authentication);

        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }
}
