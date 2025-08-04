package pers.god.demo.algorithm;

import cn.hutool.crypto.SmUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author chuhao
 * @Date 2025/7/7
 * @Version 1.0.0
 */
public class Test2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("13052350169", "17721184550");
        for (String s : list) {
            System.out.println(SmUtil.sm3(s));
        }
    }
}
