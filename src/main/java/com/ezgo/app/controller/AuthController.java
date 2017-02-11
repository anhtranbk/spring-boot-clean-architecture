package com.ezgo.app.controller;

import com.ezgo.app.dto.SignUpDTO;
import com.ezgo.app.dto.UserInfo;
import com.ezgo.app.service.AuthService;
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
    public UserInfo userSignUp(@RequestBody SignUpDTO signUpDTO) {
        return authService.userSignUp(signUpDTO);
    }
}
