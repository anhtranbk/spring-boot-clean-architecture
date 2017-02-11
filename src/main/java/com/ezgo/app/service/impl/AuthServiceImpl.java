package com.ezgo.app.service.impl;

import com.ezgo.app.domain.User;
import com.ezgo.app.dto.SignUpDTO;
import com.ezgo.app.dto.UserDTO;
import com.ezgo.app.exception.UserAlreadyExistsException;
import com.ezgo.app.repository.UserRepository;
import com.ezgo.app.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO userSignUp(SignUpDTO signUpDTO) {
        if (userRepository.exists(signUpDTO.getUsername(), signUpDTO.getEmail())) {
            throw new UserAlreadyExistsException("Username or email already existed");
        }

        User user = new User();
        user.setUsername(signUpDTO.getUsername());
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        user.setGender(signUpDTO.getGender());
        user.setAddress(signUpDTO.getAddress());
        user.setDob(signUpDTO.getDob());

        user = userRepository.save(user);
        return new UserDTO(user);
    }
}
