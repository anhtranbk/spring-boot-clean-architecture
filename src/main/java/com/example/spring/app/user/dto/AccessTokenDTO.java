package com.example.spring.app.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccessTokenDTO {

    private String accessToken;
    private String refreshToken;
    private Date expiresAt;
    private String tokenType;
}
