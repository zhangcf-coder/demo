package com.example.demo.mq.rabbitmq.pubsub;

import com.example.demo.mq.rabbitmq.constants.RabbitConstant;
import com.example.demo.mq.rabbitmq.utils.RabbitUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class WhearBureau {
    public static void main(String args[]) throws IOException, TimeoutException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();

        String input = new Scanner(System.in).next();

        channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER, "", null,
                input.getBytes());
        channel.close();
        connection.close();
    }
}
