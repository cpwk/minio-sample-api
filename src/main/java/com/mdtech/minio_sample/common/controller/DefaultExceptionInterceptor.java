package com.mdtech.minio_sample.common.controller;

import com.mdtech.minio_sample.common.entity.ErrorCode;
import com.mdtech.minio_sample.common.entity.ErrorCodeVO;
import com.mdtech.minio_sample.common.exception.ServiceException;
import com.mdtech.minio_sample.common.util.L;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@ControllerAdvice
public class DefaultExceptionInterceptor {

    @ExceptionHandler(Throwable.class)
    public ModelAndView handleError(HttpServletRequest request, HandlerMethod handlerMethod, Throwable ex) {
        L.error(ex);

        int code = ErrorCode.UNKNOWN.getCode();
        ErrorCodeVO error = new ErrorCodeVO(code, "系统错误");

        if (ex instanceof ServiceException) {
            ServiceException se = (ServiceException) ex;
            code = se.getCode();
            if (code == ErrorCode.DETAILED.getCode()) {
                error = new ErrorCodeVO(se.getCode(), se.getMsg());
            } else {
                error = ErrorCodeVO.getErrorCode(code);
            }
        }

        return new ModelAndView(new JsonView(Collections.singletonMap("error", error)));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Throwable ex) {
        return new ModelAndView(new NotFoundView());
    }
}