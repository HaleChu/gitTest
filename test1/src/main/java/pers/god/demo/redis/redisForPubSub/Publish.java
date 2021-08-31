package pers.god.demo.redis.redisForPubSub;

import pers.god.demo.redis.RedisUtil;
import redis.clients.jedis.Jedis;

public class Publish {

    public static void main(String[] args) {
        final Jedis jedis = RedisUtil.getJedis();
        jedis.publish("channel1", "wdnmd");
    }
}
