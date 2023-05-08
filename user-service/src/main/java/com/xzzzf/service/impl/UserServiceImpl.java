package com.xzzzf.service.impl;

import com.xzzzf.entity.User;
import com.xzzzf.mapper.UserMapper;
import com.xzzzf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer uid) {
        return userMapper.getUserById(uid);
    }
}
