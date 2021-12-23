package com.example.demo.mq.rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitUtils {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    static {
        connectionFactory.setHost("10.34.43.22");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/zcf");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
