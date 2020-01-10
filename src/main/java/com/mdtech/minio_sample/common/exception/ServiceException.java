package com.mdtech.minio_sample.common.exception;

public class ServiceException extends Exception {

    private int code;
    private String msg;

    public ServiceException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(int code) {
        super();
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
