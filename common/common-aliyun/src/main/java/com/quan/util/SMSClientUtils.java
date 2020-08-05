package com.quan.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * @author 全俊
 * @version 1.0
 * @className SMSClientUtils
 * @description TODO
 * @date 2020/8/3 23:05
 */
@Component
public class SMSClientUtils {
    /**
     * @param phoneNumber
     * @param templateParam
     * @return java.lang.Boolean
     * @description TODO
     * @methodName send
     * @author 全俊
     * @date 2020/8/4 0:38
     */
    public Boolean send(String phoneNumber, String templateParam) {
        CommonResponse response = null;
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G8V38ygaauwFuXKnyXC", "SDZcf5JYoyYuK7qZUfTSYg798ysCBA");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "新冠物资管理系统");
        request.putQueryParameter("TemplateCode", "SMS_198925515");
        request.putQueryParameter("TemplateParam", templateParam);
        try {
            response = client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String code = null;
        try {
            JsonNode carJsonNode = objectMapper.readTree(response.getData());
            code = carJsonNode.findValue("Code").asText();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "OK".equalsIgnoreCase(code);
    }
}
