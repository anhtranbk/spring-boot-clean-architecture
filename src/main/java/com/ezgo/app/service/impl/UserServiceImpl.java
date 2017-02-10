package com.ezgo.app.service.impl;

import com.ezgo.app.dto.UserDTO;
import com.ezgo.app.repository.UserRepository;
import com.ezgo.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserDTO getMyProfile() {
        return null;
    }
}
