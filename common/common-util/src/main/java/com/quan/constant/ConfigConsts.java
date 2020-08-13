package com.quan.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 全俊
 * @version 1.0
 * @className ConfigConsts
 * @description TODO
 * @date 2020/8/6 10:15
 */
public class ConfigConsts {
    public static final List<String> LIST = new ArrayList<>();
    public static final String OPTIONS = "OPTIONS";

    static {
        LIST.add("/userservice/login/");
        LIST.add("/userservice/login/sendSMS");
        LIST.add("/userservice/login/loginOut");
        LIST.add("/userservice/login/register");
        LIST.add("/userservice/login/captcha");
        LIST.add("/swagger-ui.html/**");
        LIST.add("/webjars/**");
        LIST.add("/swagger-resources/**");
        LIST.add("/v2/**");
        LIST.add("/error/**");
        LIST.add("/resources/**");
    }
}
