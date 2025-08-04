package pers.god.demo.business;

import cn.hutool.crypto.SmUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author chuhao
 * @Date 2025/7/25
 * @Version 1.0.0
 */
public class Sm3Demo {

    public static void main(String[] args) {
        List<String> certificateNoList = Arrays.asList(
                ""
        );
        for (String certificateNo : certificateNoList) {
            System.out.println(SmUtil.sm3(certificateNo));
        }

    }
}
