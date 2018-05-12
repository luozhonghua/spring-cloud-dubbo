package com.cn.spring.cloud.dubbo.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * Created by luozhonghua on 2018/5/12.
 */


@RunWith(SpringRunner.class)
@SpringBootApplication
@EnableAutoConfiguration
public class SpringbootJmsApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue("mytest.queue");

        for(int i=0; i<5; i++){
            producer.sendMessage(destination, i+"  =========================================================================");
        }
    }


}
