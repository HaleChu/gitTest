package pers.god.demo.redis.redisForPubSub;

import redis.clients.jedis.JedisPubSub;

public class MyRedisPubSub extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.printf("receive redis published message, channel %s, message %s%n", channel, message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.printf("subscribe redis channel success, channel %s, subscribedChannels %d%n", channel, subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.printf("unsubscribe redis channel, channel %s, subscribedChannels %d%n", channel, subscribedChannels);
    }
}
