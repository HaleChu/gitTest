package pers.god.demo.redis;

import redis.clients.jedis.Jedis;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/11/13
 */
public class RedisDemo {

    public static void main(String[] args) {
        final Jedis jedis = RedisUtil.getJedis();
    }
}
