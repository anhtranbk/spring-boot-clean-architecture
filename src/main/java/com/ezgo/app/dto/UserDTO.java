package com.ezgo.app.dto;

import com.ezgo.app.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserDTO implements UserInfo, Serializable {
    private Long id;
    private String username;
    private String email;
    private Date dob;
    private String gender;
    private String address;
    private Date createdAt;
    private Date updatedAt;

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        this.dob = entity.getDob();
        this.gender = entity.getGender();
        this.address = entity.getAddress();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }
}
