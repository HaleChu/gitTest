package pers.god.demo.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Recieve {

    private final static String QUEUE_NAME = "god";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("消费者标签:" + consumerTag);
            System.out.println(" [x] Received '" + message + "'");
        };

        CancelCallback cancelCallback = consumerTag -> System.out.println("取消操作-----服务器生成的consumerTag:" + consumerTag);
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
