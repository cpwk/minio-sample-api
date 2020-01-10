package com.mdtech.minio_sample.common.entity;

public class ErrorCodeVO {

    private int code;
    private String msg;

    public static ErrorCodeVO getErrorCode(int code) {
        for (ErrorCode ec : ErrorCode.values()) {
            if (ec.getCode() == code) {
                return new ErrorCodeVO(ec.getCode(), ec.getMsg());
            }
        }
        return new ErrorCodeVO(ErrorCode.UNKNOWN.getCode(), ErrorCode.UNKNOWN.getMsg());
    }

    public ErrorCodeVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
