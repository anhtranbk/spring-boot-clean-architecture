package com.example.spring.app.service.impl;

import com.example.spring.app.dto.UserDTO;
import com.example.spring.app.repository.UserRepository;
import com.example.spring.app.service.UserService;
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
