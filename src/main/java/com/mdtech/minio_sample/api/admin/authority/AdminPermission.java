package com.mdtech.minio_sample.api.admin.authority;


import com.mdtech.minio_sample.common.entity.Constants;

public enum AdminPermission {

    //    none
    NONE("", ""),

    /* 功能模块 */
    // admin&role
    ROLE_EDIT("管理组管理", Constants.LEVEL_IMPORTANT), ADMIN_LIST("管理员列表", Constants.LEVEL_IMPORTANT), ADMIN_EDIT("编辑管理员", Constants.LEVEL_IMPORTANT);

    private String val;
    private String level;

    AdminPermission(String val, String level) {
        this.val = val;
        this.level = level;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
