package com.ezgo.app.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignInDTO implements Serializable {
    private String email;
    private String password;
}
