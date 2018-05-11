package com.cn.spring.cloud.dubbo.controller;

import com.cn.spring.cloud.dubbo.api.UserService;
import com.cn.spring.cloud.dubbo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserDTO findUser(@PathVariable Integer id) {
        return userService.findUser(id);
    }
}
