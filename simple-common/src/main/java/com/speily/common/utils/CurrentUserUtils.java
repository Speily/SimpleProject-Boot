package com.speily.common.utils;

import com.speily.common.ProjectConfig;
import com.speily.entity.User;
import org.apache.shiro.SecurityUtils;

/**
 * 当前登录用户工具类
 * 根据不同项目获取其登录用户
 * 1、manager shiro principle
 * 2、mobile 待定
 */
public class CurrentUserUtils {

    public static User getSysUser(){
        User user = null;
        //1、使用shiro登录
        if(ProjectConfig.isShiroLogin()){
            Object obj = SecurityUtils.getSubject().getPrincipal();
            if (StringUtils.isNotNull(obj)) {
                user = new User();
                BeanUtils.copyBeanProp(user, obj);
            }
        }
        return user;
    }

}
