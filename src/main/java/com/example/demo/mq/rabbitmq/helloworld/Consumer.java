package com.example.demo.mq.rabbitmq.helloworld;

import com.example.demo.mq.rabbitmq.constants.RabbitConstant;
import com.example.demo.mq.rabbitmq.utils.RabbitUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

public class Consumer {

    public static void main(String args[]) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        /** 创建队列 声明并创建一个队列 如果队列已经存在 则使用这个队列
         * String var1, boolean var2, boolean var3, boolean var4, Map<String, Object> var5
         * var1 队列名称ID
         * var2 是否持久化 false对应不持久化数据 MQ停掉数据就会丢失
         * var3 是否队列私有化 false 代表所有的消费者都可以访问 true 代表只有第一次拥有它的队列才可以一直使用 其他消费者不让访问
         * var4 连接停掉之后是否自动删除队列 false 代表连接删除之后不自动删除队列
         */
        channel.queueDeclare(RabbitConstant.QUEUE_HELLOWORLD, false, false, false, null);

        channel.basicConsume(RabbitConstant.QUEUE_HELLOWORLD, false, new Reciver(channel));
    }
}

class Reciver extends DefaultConsumer {
    private Channel channel;

    public Reciver(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.out.println("消费者接收到的消息:" + new String(body, "utf-8"));
        long deliveryTag = envelope.getDeliveryTag();
        System.out.println("消费者接收到消息的tag:" + deliveryTag);
        // false 只确认签收当前消息 true代表签收该消费者所有未签收的消息
        channel.basicAck(deliveryTag, false);
    }
}
