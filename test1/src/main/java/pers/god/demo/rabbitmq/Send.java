package pers.god.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private final static String QUEUE_NAME = "god";

    /**
     * AMQP.BasicProperties
     * <p>
     * String contentType [消息内容的类型]
     * String contentEncoding [消息内容的编码格式]
     * Map<String,Object> headers [header类型的交换机可以用到]
     * Integer deliveryMode [消息持久化 1-不持久化 2-持久化]
     * Integer priority [优先级]
     * String correlationId [关联id]
     * String replyTo [通常用于命名回调队列]
     * String expiration [设置过期消息过期的时间]
     * String messageId [消息id]
     * Date timestamp [消息的时间戳]
     * String type [类型]
     * String userId [用户id]
     * String appId [应用程序id]
     * String clusterId [集群id]
     */
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "wdnmd";
            for (int i = 0; i < 10; i++) {
                String msg = message + i;
                channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
                System.out.println("[x]Sent'" + msg + "'");
                Thread.sleep(1000);
            }
        } catch (IOException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
