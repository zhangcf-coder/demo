package com.example.demo.mq.rabbitmq.workqueue;

import com.example.demo.mq.rabbitmq.constants.RabbitConstant;
import com.example.demo.mq.rabbitmq.utils.RabbitUtils;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class OrderSystem {
    public static void main(String args[]) throws IOException, TimeoutException {

        Connection connection = RabbitUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(RabbitConstant.QUEUE_SMS, false, false, false, null);

        for (int i = 1; i <= 100; i++) {
            SMS sms = new SMS("乘客" + i, "电话:1867762332" + i, "购票成功");
            String jsonMsg = new Gson().toJson(sms);
            channel.basicPublish("", RabbitConstant.QUEUE_SMS, null, jsonMsg.getBytes());
        }
        System.out.println("发送消息成功");
        channel.close();
        connection.close();
    }
}
