package com.xzzzf.service.client;

import com.xzzzf.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackClient implements UserClient{
    @Override
    public User findUserById(Integer uid) {
        User user = new User();
        user.setName("补救措施~");
        return user;
    }
}
