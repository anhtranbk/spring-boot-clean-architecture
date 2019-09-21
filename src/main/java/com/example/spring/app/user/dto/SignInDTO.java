package com.example.spring.app.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignInDTO implements Serializable {
    private String email;
    private String password;
}
