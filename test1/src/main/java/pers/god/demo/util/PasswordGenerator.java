package pers.god.demo.util;

import pers.god.demo.password.PasswordEncoderHelper;

import java.util.Random;

/**
 * @Author chuhao
 * @Date 2023/6/26
 * @Version 1.0.0
 */
public class PasswordGenerator {

    private static final String SPECIAL_CHARS = "!@#3%&*_=+";

    private static int nextIndex(char[] chars, Random rnd) {
        int index = rnd.nextInt(chars.length);
        while (chars[index] != 0) {
            index = rnd.nextInt(chars.length);
        }
        return index;
    }

    private static char nextSpecialChar(Random rnd) {
        return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
    }

    private static char nextUpperlLetter(Random rnd) {
        return (char) ('A' + rnd.nextInt(26));
    }

    private static char nextLowerLetter(Random rnd) {
        return (char) ('a' + rnd.nextInt(26));
    }

    private static char nextNumLetter(Random rnd) {
        return (char) ('0' + rnd.nextInt(10));
    }

    private static char nextChar(Random rnd) {
        switch (rnd.nextInt(4)) {
            case 0:
                return (char) ('a' + rnd.nextInt(26));
            case 1:
                return (char) ('A' + rnd.nextInt(26));
            default:
                return (char) ('0' + rnd.nextInt(10));
        }
    }

    /**
     * 生成随机密码：复杂8位
     *
     * @return 密码字符串
     */
    public static String randomPassword() {
        char[] chars = new char[8];
        Random rnd = new Random();
        chars[nextIndex(chars, rnd)] = nextUpperlLetter(rnd);
        chars[nextIndex(chars, rnd)] = nextLowerLetter(rnd);
        chars[nextIndex(chars, rnd)] = nextNumLetter(rnd);
        for (int i = 0; i < 8; i++) {
            if (chars[i] == 0) {
                chars[i] = nextChar(rnd);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(randomPassword());
        System.out.println(PasswordEncoderHelper.encodeByDES("123456"));

        String name = "hjycServicesAPP__20240805182521.apk";
        System.out.println(name.substring(name.lastIndexOf(".") + 1));
    }
}
