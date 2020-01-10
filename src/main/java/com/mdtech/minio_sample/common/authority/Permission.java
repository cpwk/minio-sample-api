package com.mdtech.minio_sample.common.authority;

public class Permission {

    private String code;
    private String name;
    private String level;

    public Permission() {
        super();
    }

    public Permission(String code, String name, String level) {
        super();
        this.code = code;
        this.name = name;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
