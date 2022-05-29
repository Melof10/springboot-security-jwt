package com.melof10.auth.security.jwt;

import com.melof10.auth.security.dto.JwtDTO;
import com.melof10.auth.security.entities.User;
import com.melof10.auth.security.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtReturnReq {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private IUserService iUserService;

    public JwtDTO getTokenRequest(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = iUserService.getByUsername(userDetails.getUsername()).get();
        return new JwtDTO(jwt, userDetails.getUsername(), user.getEmail(), userDetails.getAuthorities());
    }
}
