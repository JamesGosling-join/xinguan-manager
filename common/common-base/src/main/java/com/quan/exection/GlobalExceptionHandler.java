package com.quan.exection;

import com.quan.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 全俊
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        log.error(e.toString());
        e.printStackTrace();
        return Result.fail().message(e.getMessage());
    }
}
