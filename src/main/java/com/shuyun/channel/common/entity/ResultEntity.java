package com.shuyun.channel.common.entity;

import com.shuyun.channel.common.enums.ResponseErrorEnum;

/**
 * @author kui.liu
 * @since 2014/09/24 下午8:29
 */
public class ResultEntity<T> {

    private T data;

    private boolean success;

    private ResponseErrorEnum errorInfo;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResponseErrorEnum getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ResponseErrorEnum errorInfo) {
        this.errorInfo = errorInfo;
    }
}
