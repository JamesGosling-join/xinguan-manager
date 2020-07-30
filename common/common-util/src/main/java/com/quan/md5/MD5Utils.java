package com.quan.md5;

import org.apache.shiro.crypto.hash.SimpleHash;


/**
 * @author 全俊
 */
public class MD5Utils {

    /**
     * 密码加密
     * @return 加密后的密码
     */
    public static String md5Encryption(String source,String salt){
        String algorithmName = "MD5";
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        return simpleHash+"";
    }
}
