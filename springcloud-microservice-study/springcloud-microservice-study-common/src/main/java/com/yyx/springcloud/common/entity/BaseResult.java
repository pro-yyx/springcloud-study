package com.yyx.springcloud.common.entity;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 14:04
 */
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -1863576074861760104L;

    private static final String CODE_SUCCESS = "200";

    private static final String MESSAGE_SUCCESS ="调用成功";

    private String code;

    private String message;

    private T data;

    public BaseResult() {
    }

    public BaseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T>  BaseResult<T> success() {
        return new BaseResult(CODE_SUCCESS, MESSAGE_SUCCESS);
    }

    public static <T>  BaseResult<T> success(String message) {
        return new BaseResult(CODE_SUCCESS, message);
    }

    public static <T>  BaseResult<T> success(T data) {
        return new BaseResult(CODE_SUCCESS, MESSAGE_SUCCESS,data);
    }

    public static <T>  BaseResult<T> fail(String code,String message) {
        return new BaseResult<>(code, message);
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getCodeSuccess() {
        return CODE_SUCCESS;
    }

    public static String getMessageSuccess() {
        return MESSAGE_SUCCESS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

