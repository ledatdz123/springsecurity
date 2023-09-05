package com.example.securityapplication.service;

import com.example.securityapplication.model.UserApp;
import com.example.securityapplication.repository.UserRepository;
import com.example.securityapplication.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl{
    @Autowired
    private UserRepository userRepo;

    public UserApp getProfile(Authentication authentication) {
        Optional<UserApp> userApp = userRepo.findByUsername(authentication.getName());
        if (userApp.isPresent()) {
            return userApp.get();
        }
        throw new UsernameNotFoundException("not found");
    }
}
