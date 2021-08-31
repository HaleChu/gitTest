package pers.god.demo.redis.redisForPubSub;

import pers.god.demo.redis.RedisUtil;
import redis.clients.jedis.Jedis;

public class Consumer {

    public static void main(String[] args) {
        final Jedis jedis = RedisUtil.getJedis();
        jedis.subscribe(new MyRedisPubSub(), "channel1");
    }
}
