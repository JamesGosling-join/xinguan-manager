package com.quan.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 公共返回结果类
 *
 * @author 全俊
 */
@Data
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "服务器当前时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public static Result success() {
        Result result = new Result();
        result.success = ResultCode.SUCCESS.getFLAG();
        result.message = ResultCode.SUCCESS.getMESSAGE();
        result.code = ResultCode.SUCCESS.getCODE();
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.success = ResultCode.FAIL.getFLAG();
        result.code = ResultCode.FAIL.getCODE();
        result.message = ResultCode.FAIL.getMESSAGE();
        return result;
    }

    public Result data(T data) {
        this.data = data;
        return this;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public Result code(Integer code) {
        this.code = code;
        return this;
    }
}
