package com.example.demo.mq.rabbitmq.helloworld;

import com.example.demo.mq.rabbitmq.constants.RabbitConstant;
import com.example.demo.mq.rabbitmq.utils.RabbitUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String args[]) throws IOException, TimeoutException {
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

        String message = "hello zcf你好";
        /**
         * var1 exchange 交换机 暂时用不到 在后面进行发布订阅时才会用到
         * var2 队列名称
         * var3 额外的参数设置
         * var4 是要传递的消息字节数组
         */
        channel.basicPublish("", RabbitConstant.QUEUE_HELLOWORLD, null, message.getBytes());
        channel.close();
        connection.close();
        System.out.println("==发送成功==");
    }
}
