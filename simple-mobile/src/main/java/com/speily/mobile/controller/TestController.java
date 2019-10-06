package com.speily.mobile.controller;

import com.speily.entity.User;
import com.speily.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/test")
    public Object test(){
        User user = new User();
        user.setUserName("张三");
        return user;
    }


}
