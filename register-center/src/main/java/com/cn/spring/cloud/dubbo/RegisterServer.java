package com.cn.spring.cloud.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by luozhonghua on 2017/6/17.
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterServer {
   //RegisterServer
    public static void main(String[] args) {
        SpringApplication.run(RegisterServer.class, args);
    }
}
