package com.cn.spring.cloud.dubbo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by luozhonghua on 2017/7/5.
 */
@Component
@Data
@ConfigurationProperties(prefix = "demo")
public class DemoConfig {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
