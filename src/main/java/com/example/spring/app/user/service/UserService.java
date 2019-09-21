package com.example.spring.app.user.service;

import com.example.spring.app.user.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getMyProfile();
}
