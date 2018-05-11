package com.cn.spring.cloud.dubbo.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by luozhonghua on 2017/7/13.
 */
@EnableZuulProxy
@SpringCloudApplication
public class ServiceGateway {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceGateway.class).web(true).run(args);
    }

}
