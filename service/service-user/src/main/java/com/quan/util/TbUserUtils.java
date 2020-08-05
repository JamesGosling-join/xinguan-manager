package com.quan.util;

import com.quan.md5.MD5Utils;
import com.quan.pojo.TbUser;

import java.util.UUID;

/**
 * @author 全俊
 * @version 1.0
 * @className TbUserUtils
 * @description TODO
 * @date 2020/8/4 16:08
 */
public class TbUserUtils {
    public static void addUtil(TbUser tbUser) {
        tbUser.setSalt(UUID.randomUUID().toString().substring(0, 32));
        tbUser.setPassword(MD5Utils.md5Encryption(tbUser.getPassword(), tbUser.getSalt()));
        tbUser.setAvatar("https://avatars.dicebear.com/v2/male/" + tbUser.getUsername() + ".svg");
    }
}
