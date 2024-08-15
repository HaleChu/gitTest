package pers.god.demo.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * 身份证生成
 */
public class PersonInfoGenerator {

    /**
     * 姓名
     */
    /**
     * 身份证
     */
    public static String generateRandomIDCard() {
        Random random = new Random();
        StringBuilder idCard = new StringBuilder();

        // 前六位地址码，随机生成省份和城市码
        for (int i = 0; i < 6; i++) {
            idCard.append(random.nextInt(10));
        }

        // 出生年月日码
        Calendar birthday = Calendar.getInstance();
        birthday.set(1949, Calendar.OCTOBER, 1); // 最小日期101日
        long start = birthday.getTimeInMillis();
        birthday.set(2021, Calendar.DECEMBER, 31); // 最大日期1231日
        long end = birthday.getTimeInMillis();
        long randomTime = start + (long) (random.nextDouble() * (end - start));
        birthday.setTimeInMillis(randomTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        idCard.append(sdf.format(birthday.getTime()));

        // 顺序码，在特定范围内随机生成
        for (int i = 0; i < 3; i++) {
            idCard.append(random.nextInt(10));
        }

        // 校验码计算
        int sum = 0;
        if (idCard.length() == 18) {
            for (int i = 0; i < 17; i++) {
                sum += (int) (Integer.parseInt(String.valueOf(idCard.charAt(i))) * (Math.pow(2, 17 - i) % 11));
            }
        }
        char checkCode = "10X98765432".charAt(sum % 11);
        idCard.append(checkCode);

        return idCard.toString();
    }

    /**
     * 手机号
     */
    public static String generateRandomPhoneNumber() {
        List<String> startCodeList = Arrays.asList("134", "135", "136", "137",
                "138", "139", "147", "150", "151", "152", "157", "158", "159",
                "182", "183", "187", "188", "178", "130", "131", "132", "155",
                "156", "185", "186", "133", "153", "177", "180", "181", "189");
        Random random = new Random();
        int index = random.nextInt(startCodeList.size());
        int endCode = random.nextInt(99999999);
        return startCodeList.get(index) + endCode;
    }
}

