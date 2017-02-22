package com.ezgo.app.dto;

import java.util.Date;

public interface UserInfo {
    Long getId();

    String getUsername();

    String getEmail();

    Date getDob();

    String getGender();

    String getAddress();

    Date getCreatedAt();

    Date getUpdatedAt();
}
