package com.mdtech.minio_sample.api.admin.model;

import javax.persistence.*;

@Entity
@Table(name = "admin_session")
public class AdminSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "token")
    private String token;

    @Column(name = "signin_at")
    private Long signinAt;

    @Column(name = "expire_at")
    private Long expireAt;

    @Column(name = "ip")
    private String ip;

    @Column(name = "location")
    private String location;

    public AdminSession() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getSigninAt() {
        return signinAt;
    }

    public void setSigninAt(Long signinAt) {
        this.signinAt = signinAt;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}