package org.ddd.demo.common.exception;

import org.ddd.demo.common.resultCode.CommonResultCode;
import org.ddd.demo.common.resultCode.ResultCode;
import org.springframework.stereotype.Component;

/**
 * @author huangjiachang
 * @date 2023/8/9
 */
public class DemoException extends RuntimeException{
    private Integer code;
    private String[] args;

    public DemoException() {
    }

    public DemoException(String message) {
        super(message);
        this.code = CommonResultCode.BUSINESS_ERROR.getCode();
    }

    public DemoException(String message, String[] args) {
        super(message);
        this.code = CommonResultCode.BUSINESS_ERROR.getCode();
        this.args = args;
    }

    public DemoException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    public DemoException(ResultCode resultCode, String[] args) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.args = args;
    }

    public DemoException(ResultCode resultCode, String message) {
        super(message);
        this.code = resultCode.getCode();
    }

    public DemoException(String message, Throwable cause) {
        super(message, cause);
        this.code = CommonResultCode.BUSINESS_ERROR.getCode();
    }

    public DemoException(Throwable cause) {
        super(cause);
        this.code = CommonResultCode.BUSINESS_ERROR.getCode();
    }

    public DemoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = CommonResultCode.BUSINESS_ERROR.getCode();
    }

    public Integer getCode() {
        return this.code;
    }

    public String[] getArgs() {
        return this.args;
    }
}
