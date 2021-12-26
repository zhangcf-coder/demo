package com.example.demo.mq.rabbitmq.pubsub;

import com.example.demo.mq.rabbitmq.constants.RabbitConstant;
import com.example.demo.mq.rabbitmq.utils.RabbitUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

public class BaiDu {

    public static void main(String args[]) throws IOException {

        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(RabbitConstant.QUEUE_BAIDU, false, false, false, null);

        channel.basicQos(1);
        channel.queueBind(RabbitConstant.QUEUE_BAIDU, RabbitConstant.EXCHANGE_WEATHER, "");

        channel.basicConsume(RabbitConstant.QUEUE_BAIDU, false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("广播模式百度接收到的信息:" + new String (body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
