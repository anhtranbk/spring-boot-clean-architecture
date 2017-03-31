package com.example.spring.app.service;

import com.example.spring.app.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getMyProfile();
}
