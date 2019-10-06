package com.speily.common.utils;

import com.speily.entity.User;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 系统密码工具
 */
public class PwdUtils {

    public static boolean matches(User user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
    }

    public static String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex().toString();
    }
}
