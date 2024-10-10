package pers.god.demo.snowFlake;

import cn.hutool.core.util.IdUtil;

import java.util.Locale;

/**
 * @Author chuhao
 * @Date 2024/7/2
 * @Version 1.0.0
 */
public class SnowFlakeIdDemo {

    public static void main(String[] args) {
        test2(200);
    }

    public static void test(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(IdUtil.fastSimpleUUID());
        }
    }

    public static void test1(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(IdUtil.simpleUUID());
        }
    }

    public static void test2(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(IdUtil.fastSimpleUUID().toUpperCase(Locale.ROOT));
        }
    }

    public static void test3(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(IdUtil.fastSimpleUUID());
        }
    }

    public static void test4(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(IdUtil.randomUUID());
        }
    }
}
