package com.xzzzf.controller;

import com.xzzzf.entity.User;
import com.xzzzf.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid) {
        System.out.println("被调用——————————");
        return userService.getUserById(uid);
    }
}
