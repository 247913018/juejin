package com.sgcc.juejin.config;

import java.io.Serializable;

/**
 * @author caomingming
 */
public class ResponseResult<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final Integer SUCCESS = 1000;

    public static final Integer FAIL = 1004;

    private Integer returnCode;

    private String returnMsg;

    private T data;

    public ResponseResult() {

    }

    public ResponseResult(T data) {
        this(SUCCESS, "操作成功", data);
    }

    public ResponseResult(Integer returnCode, String returnMsg) {
        this(returnCode, returnMsg, null);
    }

    public ResponseResult(Integer returnCode, String returnMsg, T data) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>(SUCCESS, "操作成功");
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(data);
    }

    public static <T> ResponseResult<T> fail() {
        return new ResponseResult<T>(FAIL, "服务器繁忙，请稍后再试");
    }

    public static <T> ResponseResult<T> fail(String message) {
        return new ResponseResult<T>(FAIL, message);
    }

    public static <T> ResponseResult<T> fail(Integer code, String message, T data) {
        return new ResponseResult<T>(code, message, data);
    }

    public static <T> ResponseResult<T> fail(Integer code, String message) {
        return new ResponseResult<T>(code, message);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public static <T> ResponseResult<T> SUCCESS(String message) {
        return new ResponseResult<T>(SUCCESS, message);
    }
}
