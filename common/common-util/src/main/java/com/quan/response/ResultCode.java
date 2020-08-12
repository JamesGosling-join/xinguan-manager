package com.quan.response;

import lombok.Getter;

/**
 * @author 全俊
 */
@Getter
public enum ResultCode {
    /**
     * 代表成功
     */
    SUCCESS(20000, "成功", true),
    /**
     * 代表失败
     */
    FAIL(20001, "失败", false);
    private final Integer CODE;
    private final String MESSAGE;
    private final Boolean FLAG;

    private ResultCode(Integer code, String message, Boolean flag) {
        this.CODE = code;
        this.MESSAGE = message;
        this.FLAG = flag;
    }
}
