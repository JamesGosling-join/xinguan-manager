package com.quan.captcha;

import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 全俊
 * @version 1.0
 * @className CaptchaUtils
 * @description TODO
 * @date 2020/8/5 20:29
 */
@Component
public class CaptchaUtils {

    public Map<String,String> captcha(HttpServletRequest request, HttpServletResponse response, String key) throws Exception {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        captcha.setLen(3);
        captcha.getArithmeticString();
        String verCode = captcha.text().toLowerCase();
        key = UUID.randomUUID().toString();
        Map<String, String> map = new HashMap<>(2);
        map.put("key", key);
        map.put("image", captcha.toBase64());
        map.put("code",verCode);
        return map;
    }
}
