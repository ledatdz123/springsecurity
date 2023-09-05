package com.example.securityapplication.dto;

import com.example.securityapplication.model.Role;
import com.example.securityapplication.model.UserApp;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {
    private Integer userId;
    private String username;
    private String password;
    private String userImage;
    private Set<Role> authorities;
    public static UserDTO mapUserToDTO(UserApp userApp){
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(userApp.getUserId());
        userDTO.setUsername(userApp.getUsername());
        userDTO.setPassword(userApp.getPassword());
        userDTO.setUserImage(userApp.getUserImage());
        Set<String> roles=new HashSet<>();
        userDTO.setAuthorities((Set<Role>) userApp.getAuthorities());
        return userDTO;
    }

}
