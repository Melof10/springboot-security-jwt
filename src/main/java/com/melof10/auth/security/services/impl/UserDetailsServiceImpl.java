package com.melof10.auth.security.services.impl;

import com.melof10.auth.security.entities.MainUser;
import com.melof10.auth.security.entities.User;
import com.melof10.auth.security.services.IUserService;
import com.melof10.auth.security.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private Validate validate;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        User user = null;

        if(validate.validateEmail(identifier))
            user = iUserService.getByEmail(identifier).get();
        else
            user = iUserService.getByUsername(identifier).get();

        return MainUser.build(user);
    }
}
