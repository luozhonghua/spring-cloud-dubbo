package com.cn.spring.cloud.dubbo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by luozhonghua on 2018/5/12.
 *
 * 双向队列
 *
 *
 */
@Component
public class Consumer2 {



    @JmsListener(destination = "mytest.queue")
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        System.out.println("Consumer2收到的报文为:"+text);
        return "return message"+text;   //将return回的值，再发送到"out.queue"队列中
    }




}
