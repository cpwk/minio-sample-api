package com.mdtech.minio_sample.common.exception;


import com.mdtech.minio_sample.common.entity.ErrorCode;

public class DetailedException extends ServiceException {

    public DetailedException(String msg) {
        super(ErrorCode.DETAILED.getCode(), msg);
    }

}
