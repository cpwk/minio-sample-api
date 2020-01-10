package com.mdtech.minio_sample.api.admin.model;


import com.mdtech.minio_sample.common.authority.Permission;
import com.mdtech.minio_sample.common.converter.StringArrayConverter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Convert(converter = StringArrayConverter.class)
    @Column(name = "permissions")
    private List<String> permissions;

    @Transient
    private List<Permission> pstr;

    public List<Permission> getPstr() {
        return pstr;
    }

    public void setPstr(List<Permission> pstr) {
        this.pstr = pstr;
    }

    public Role() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

}