package com.cn.spring.cloud.dubbo.service.impl;

import com.cn.spring.cloud.dubbo.api.UserService;
import com.cn.spring.cloud.dubbo.config.DemoConfig;
import com.cn.spring.cloud.dubbo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    DemoConfig config;

    @Override
    public UserDTO findUser(Integer userId) {
        UserDTO user = new UserDTO();
        user.setUserId(userId);
        user.setUserName("xxxx(" + config.getTitle() + ")");
        return user;
    }
}
