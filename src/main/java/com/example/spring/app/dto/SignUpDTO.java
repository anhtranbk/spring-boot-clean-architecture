package com.example.spring.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SignUpDTO implements Serializable {
    private String username;
    private String email;
    private String password;
    private Date dob;
    private String gender;
    private String address;
}
