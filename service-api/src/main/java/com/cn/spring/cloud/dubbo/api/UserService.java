package com.cn.spring.cloud.dubbo.api;

import com.cn.spring.cloud.dubbo.dto.UserDTO;

/**
 * Created by luozhonghua on 2017/6/17.
 */
public interface UserService {

    UserDTO findUser(Integer userId);
}
