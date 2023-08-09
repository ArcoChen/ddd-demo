package org.ddd.demo.common.dto;

import org.ddd.demo.common.resultCode.CommonResultCode;
import org.ddd.demo.common.resultCode.ResultCode;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.MessageSourceSupport;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author huangjiachang
 */
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = -3430603013914181383L;
    private Integer code;
    private String msg;
    protected T data;
    private Boolean success;

    public ResultDTO() {
        this.init(CommonResultCode.SUCCESS.getCode(), (String)null, null);
    }

    public ResultDTO(ResultCode resultCode, String msg) {
        this.init(resultCode.getCode(), msg, null);
    }

    public ResultDTO(ResultCode resultCode, T data) {
        this.init(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public ResultDTO(ResultCode resultCode, T data, String msg) {
        this.init(resultCode.getCode(), msg, data);
    }

    public ResultDTO(Integer code, T data, String msg) {
        this.init(code, msg, data);
    }

    private ResultDTO(ResultCode resultCode) {
        this.init(resultCode.getCode(), resultCode.getMsg(), null);
    }

    private ResultDTO(Integer resultCode, String msg) {
        this.init(resultCode, msg, null);
    }

    public ResultDTO(ResultDTO<T> resultDTO) {
        this.init(resultDTO.getCode(), resultDTO.getMsg(), null);
    }

    private void init(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        if (Objects.nonNull(this.code)) {
            this.success = this.code.equals(CommonResultCode.SUCCESS.getCode()) ? Boolean.TRUE : Boolean.FALSE;
        }

    }

    public static <T> ResultDTO<T> success() {
        return new ResultDTO(CommonResultCode.SUCCESS);
    }

    public static <T> ResultDTO<T> success(T data) {
        return new ResultDTO(CommonResultCode.SUCCESS, data);
    }

    public static <T> ResultDTO<T> success(T data, String msg) {
        return new ResultDTO(CommonResultCode.SUCCESS, data, msg);
    }

    public static <T> ResultDTO<T> fail() {
        return new ResultDTO(CommonResultCode.SYSTEM_ERROR);
    }

    public static <T> ResultDTO<T> fail(String msg) {
        return new ResultDTO(CommonResultCode.SYSTEM_ERROR.getCode(), msg);
    }

    public static <T> ResultDTO<T> fail(Integer code, String msg) {
        return new ResultDTO(code, msg);
    }

    public static <T> ResultDTO<T> fail(Integer code, T data, String msg) {
        return new ResultDTO(code, data, msg);
    }

    public String getMsg() {
        return this.msg;
    }

    public ResultDTO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getCode() {
        return this.code;
    }

    public ResultDTO<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        if (null != this.success) {
            return this.success;
        } else {
            return Objects.nonNull(this.code) && CommonResultCode.SUCCESS.getCode().equals(this.code);
        }
    }

    @Override
    public String toString() {
        return "ResultDTO{core=" + this.code + ", msg='" + this.msg + '\'' + ", success=" + this.isSuccess() + ", data=" + this.data + '}';
    }
}
