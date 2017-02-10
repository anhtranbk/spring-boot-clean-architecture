package com.ezgo.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token", nullable = false, length = 255)
    private String username;

    @Column(name = "userId", unique = true, nullable = false, length = 127)
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expires_at", nullable = false, length = 19)
    private Date expiresAt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, length = 19)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, length = 19)
    private Date updatedAt;
}
