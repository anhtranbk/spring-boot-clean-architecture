package com.example.spring.app.user.service;

import com.example.spring.app.user.dto.AccessTokenDTO;
import com.example.spring.app.user.dto.SignUpDTO;
import com.example.spring.app.user.dto.SignInDTO;
import com.example.spring.app.user.dto.UserDTO;

public interface AuthService {

    UserDTO userSignUp(SignUpDTO signUpDTO);

    AccessTokenDTO userSignIn(SignInDTO signInDTO);
}
