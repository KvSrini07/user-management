package com.erp.userms.service;

import com.erp.userms.entity.CustomUserDetails;
import com.erp.userms.entity.UserEntity;
import com.erp.userms.repository.IUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserRepo userRepo;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Entering Into the loadUserByUsername");
        UserEntity user = userRepo.findByEmailId(username);
        if (user == null) {
            LOGGER.warn("User not found: {}", username);
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new CustomUserDetails(user);
    }
}


