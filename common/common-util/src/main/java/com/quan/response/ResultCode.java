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
    private Integer code;
    private String message;
    private Boolean success;

    private ResultCode(Integer code, String message, Boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }
}
