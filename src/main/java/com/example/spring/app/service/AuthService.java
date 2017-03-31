package com.example.spring.app.service;

import com.example.spring.app.dto.AccessTokenDTO;
import com.example.spring.app.dto.SignUpDTO;
import com.example.spring.app.dto.SignInDTO;
import com.example.spring.app.dto.UserDTO;

public interface AuthService {

    UserDTO userSignUp(SignUpDTO signUpDTO);

    AccessTokenDTO userSignIn(SignInDTO signInDTO);
}
