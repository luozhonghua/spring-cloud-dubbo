package com.cn.spring.cloud.dubbo.service.client;

import com.cn.spring.cloud.dubbo.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-provider", configuration = com.cn.spring.cloud.dubbo.service.client.BasicAuthConfiguration.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    UserDTO findUser(@PathVariable("id") Integer userId);

}
