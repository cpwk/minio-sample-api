package com.mdtech.minio_sample.common.entity;

public class Constants {

    public static int PAGESIZE_MIN = 10;
    public static int PAGESIZE_MED = 20;
    public static int PAGESIZE_MAX = 50;
    public static int PAGESIZE_INF = 10000;

    public static int CACHE_REDIS_EXPIRE = 3600 * 48;
    public static int SESSION_EXPIRE_DAYS_ADMIN = 2;
    public static int SESSION_EXPIRE_DAYS_USER = 30;

    public static final byte STATUS_OK = 1;// 默认
    public static final byte STATUS_HALT = 2;// 删除、停用、取消


    // 权限操作级别
    public static String LEVEL_PRIMARY = "blue";
    public static String LEVEL_IMPORTANT = "red";
    public static String LEVEL_WARNING = "orange";

    //文件
    public static int EXPIRE_UPLOAD = 60 * 60;
    public static int MAX_UPLOAD_SIZE = 200 * 1024 * 1024;

    public static final int ACCOUNT_SYSTEM = 0;
    public static final int ACCOUNT_ADMIN = 1;
    public static final int ACCOUNT_USER = 2;

}
