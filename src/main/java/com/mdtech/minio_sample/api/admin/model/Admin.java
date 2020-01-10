package com.mdtech.minio_sample.api.admin.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @JSONField(serialize = false)
    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "status")
    private Byte status;

    @Column(name = "signin_at")
    private Long signinAt;

    @Transient
    private Role role;

    @Transient
    private String newpassword;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Admin() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getSigninAt() {
        return signinAt;
    }

    public void setSigninAt(Long signinAt) {
        this.signinAt = signinAt;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

}