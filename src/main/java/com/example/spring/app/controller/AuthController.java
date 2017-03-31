package com.example.spring.app.controller;

import com.example.spring.app.dto.AccessTokenDTO;
import com.example.spring.app.dto.SignInDTO;
import com.example.spring.app.dto.SignUpDTO;
import com.example.spring.app.dto.UserDTO;
import com.example.spring.app.service.AuthService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@Setter
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO userSignUp(@RequestBody SignUpDTO signUpDTO) {
        return authService.userSignUp(signUpDTO);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessTokenDTO userSignIn(@RequestBody SignInDTO signInDTO) {
        return authService.userSignIn(signInDTO);
    }
}
