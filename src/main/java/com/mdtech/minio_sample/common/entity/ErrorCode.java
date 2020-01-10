package com.mdtech.minio_sample.common.entity;

public enum ErrorCode {
    // common
    DETAILED(600, ""),
    UNKNOWN(601, "操作失败"),
    UNREACHED(602, "不可操作"),
    SESSIONTIMEOUT(603, "登录超时"),
    NO_PERMISSION(604, "没有权限"),

    //common
    ERROR_MOBILE(610, "手机号码格式错误"),

    // admin
    NOUSER(620, "未知用户"),
    ERROR_PWD(621, "密码错误"),
    LOGIN_STATUS(622, "账号异常"),
    ERROR_VALCODE(623, "验证码错误或过期，请重新生成"),

    // user
    ERROR_WX_AUTH_FAIL(630, "微信授权失败"),

    //order
    ERROR_PRODUCT_TYPE(640, "订单类型错误"),
    ERROR_PAY_TYPE(641, "支付方式错误"),

    //download
    ERROR_DOWNLOAD_TIME(650, "下载次数已用完，请购买下载套餐");


    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
