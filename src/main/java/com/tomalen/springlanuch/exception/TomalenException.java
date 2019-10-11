package com.tomalen.springlanuch.exception;

/**
 * Created by codedrinker on 2019/5/28.
 */
public class TomalenException extends RuntimeException {
    private String message;
    private Integer code;

    public TomalenException(ITomalenErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
