package pers.god.demo.snowFlake;

import cn.hutool.core.util.IdUtil;

/**
 * @Author chuhao
 * @Date 2024/7/2
 * @Version 1.0.0
 */
public class SnowFlakeIdDemo {

    public static void main(String[] args) {
        String fastUUID = IdUtil.fastUUID();
        String fastSimpleUUID = IdUtil.fastSimpleUUID();
        String randomUUID = IdUtil.randomUUID();
        String simpleUUID = IdUtil.simpleUUID();
        System.out.println("fastUUID:" + fastUUID);
        System.out.println("fastSimpleUUID:" + fastSimpleUUID);
        System.out.println("randomUUID:" + randomUUID);
        System.out.println("simpleUUID:" + simpleUUID);
        System.out.println("snowFlake:");
        System.out.println(IdUtil.getSnowflake(0, 0).nextId());
        System.out.println(IdUtil.getSnowflake(0, 0).nextIdStr());
        System.out.println(IdUtil.getSnowflake(0, 1).nextIdStr());
        System.out.println(IdUtil.getSnowflake(1, 1).nextIdStr());
        System.out.println(IdUtil.getSnowflake(1, 2).nextIdStr());
    }
}
