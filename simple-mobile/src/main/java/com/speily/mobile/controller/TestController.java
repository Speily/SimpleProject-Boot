package com.speily.mobile.controller;

import com.speily.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public Object test(){
        User user = new User();
        user.setUserName("张三");
        return user;
    }


}
