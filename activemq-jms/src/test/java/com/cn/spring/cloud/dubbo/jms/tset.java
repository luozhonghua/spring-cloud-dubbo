package com.cn.spring.cloud.dubbo.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Destination;

/**
 * Created by luozhonghua on 2018/5/12.
 */
public class tset {

    @Autowired
    private static Producer producer;

    public static void main(String [] args){

        Destination destination = new ActiveMQQueue("mytest.queue");

        for(int i=0; i<100; i++){
            producer.sendMessage(destination, "myname is chhliu!!!");
        }
    }




}
