package org.ddd.demo.common.resultCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjiachang
 * @date 2023/8/8
 */
public abstract class ResultCode {
    private static final Logger log = LoggerFactory.getLogger(ResultCode.class);
    private Integer code;
    private String msg;
    private Boolean success;

    private ResultCode() {
    }

    protected ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        ResultCode.ResponseCodeContainer.put(this);
    }

    protected ResultCode(Integer code, String msg, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        ResultCode.ResponseCodeContainer.put(this);
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return CommonResultCode.SUCCESS.getCode().equals(this.code);
    }

    public static void init() {
        log.info("ResultCode init....");
    }

    static {
        ResultCode.ResponseCodeContainer.register(CommonResultCode.class, 0, 10000);
    }

    private static class ResponseCodeContainer {
        private static final Logger log = LoggerFactory.getLogger(ResponseCodeContainer.class);
        private static final Map<Integer, ResultCode> RESPONSE_CODE_MAP = new HashMap();
        private static final Map<Class<? extends ResultCode>, int[]> RESPONSE_CODE_RANGE_MAP = new HashMap();

        private ResponseCodeContainer() {
        }

        private static void register(Class<? extends ResultCode> clazz, Integer start, Integer end) {
            if (start > end) {
                throw new IllegalArgumentException("<ResultCode> start > end!");
            } else if (RESPONSE_CODE_RANGE_MAP.containsKey(clazz)) {
                throw new IllegalArgumentException(String.format("<ResultCode> Class:%s already exist!", clazz.getSimpleName()));
            } else {
                RESPONSE_CODE_RANGE_MAP.forEach((k, v) -> {
                    if (start >= v[0] && start <= v[1] || end >= v[0] && end <= v[1]) {
                        throw new IllegalArgumentException(String.format("<ResultCode> Class:%s 's id range[%d,%d] has intersection with class:%s", clazz.getSimpleName(), start, end, k.getSimpleName()));
                    }
                });
                RESPONSE_CODE_RANGE_MAP.put(clazz, new int[]{start, end});
                Field[] fields = clazz.getFields();
                if (fields.length != 0) {
                    try {
                        fields[0].get(clazz);
                    } catch (IllegalAccessException | IllegalArgumentException var5) {
                        log.error("", var5);
                    }
                }

            }
        }

        private static void put(ResultCode codeConst) {
            int[] idRange = (int[])RESPONSE_CODE_RANGE_MAP.get(codeConst.getClass());
            if (idRange == null) {
                throw new IllegalArgumentException(String.format("<ResultCode> Class:%s has not been registered!", codeConst.getClass().getSimpleName()));
            } else {
                Integer code = codeConst.code;
                if (code >= idRange[0] && code <= idRange[1]) {
                    if (RESPONSE_CODE_MAP.containsKey(code)) {
                        log.error(String.format("<ResultCode> Id(%d) out of range[%d,%d], class:%s  core is repeat!", code, idRange[0], idRange[1], codeConst.getClass().getSimpleName()));
                        throw new IllegalArgumentException(String.format("<ResultCode> Id(%d) out of range[%d,%d], class:%s  core is repeat!", code, idRange[0], idRange[1], codeConst.getClass().getSimpleName()));
                    } else {
                        RESPONSE_CODE_MAP.put(code, codeConst);
                    }
                } else {
                    throw new IllegalArgumentException(String.format("<ResultCode> Id(%d) out of range[%d,%d], class:%s", code, idRange[0], idRange[1], codeConst.getClass().getSimpleName()));
                }
            }
        }
    }
}
