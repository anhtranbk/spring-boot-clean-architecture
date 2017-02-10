package com.ezgo.app.service;

import com.ezgo.app.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getMyProfile();
}
