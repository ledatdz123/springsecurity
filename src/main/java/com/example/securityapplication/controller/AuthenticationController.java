package com.example.securityapplication.controller;

import com.example.securityapplication.dto.RegistrationDTO;
import com.example.securityapplication.dto.UserResponseDTO;
import com.example.securityapplication.model.UserApp;
import com.example.securityapplication.security.services.AuthenticationService;
import com.example.securityapplication.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @PostMapping("/register")
    public UserApp registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
//    @PostMapping("/login")
//    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
//        return authenticationService.loginUser(body.getUsername(), body.getPassword());
//    }

    @PostMapping("/login")
    public UserResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
    @GetMapping("/profile")
    public UserApp getProfile(Authentication authentication){
        UserApp userApp= userServiceImpl.getProfile(authentication);
        return userApp;
    }
}
