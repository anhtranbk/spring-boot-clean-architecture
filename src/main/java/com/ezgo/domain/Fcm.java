package com.ezgo.domain;
// Generated Dec 27, 2016 4:46:31 PM by Hibernate Tools 5.2.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Fcm generated by hbm2java
 */
@Entity
@Table(name = "fcm", catalog = "ezgo")
public class Fcm implements java.io.Serializable {

    private Integer id;
    private String fcmId;
    private String username;
    private String ua;
    private String description;
    private Date createTime;

    public Fcm() {
    }

    public Fcm(String fcmId, String username, Date createTime) {
        this.fcmId = fcmId;
        this.username = username;
        this.createTime = createTime;
    }

    public Fcm(String fcmId, String username, String ua, String description, Date createTime) {
        this.fcmId = fcmId;
        this.username = username;
        this.ua = ua;
        this.description = description;
        this.createTime = createTime;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "fcm_id", nullable = false, length = 250)
    public String getFcmId() {
        return this.fcmId;
    }

    public void setFcmId(String fcmId) {
        this.fcmId = fcmId;
    }

    @Column(name = "username", nullable = false, length = 250)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "ua", length = 250)
    public String getUa() {
        return this.ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    @Column(name = "description", length = 250)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = false, length = 19)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
