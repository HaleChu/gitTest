package pers.god.demo.snowFlake;

import java.net.URLEncoder;

/**
 * @Author chuhao
 * @Date 2024/8/1
 * @Version 1.0.0
 */
public class Cbdemo {

    public static void main(String[] args) {
        String str1 = "123456";
        System.out.println(PasswordEncoderHelper.encode(str1));
        String str2 = "Abc@123456";
        System.out.println(PasswordEncoderHelper.encode(str2));
        String str3 = "YGzPXzXtzAI=";
        System.out.println(PasswordEncoderHelper.decryptByDES(str3));
        String str4 = "poogn414PrOBAXz0nTF50A==";
        System.out.println(PasswordEncoderHelper.decryptByDES(str4));
        System.out.println(PasswordEncoderHelper.decryptByDES("YbsXngrNJ8Y="));
        System.out.println(PasswordEncoderHelper.decryptByDES("YbsXngrNJ8Y="));

        System.out.println(URLEncoder.encode(""));
    }
}
