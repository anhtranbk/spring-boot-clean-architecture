package com.ezgo.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccessTokenDTO {

    private String accessToken;
    private String refreshToken;
    private Date expiresAt;
    private String tokenType;
}
