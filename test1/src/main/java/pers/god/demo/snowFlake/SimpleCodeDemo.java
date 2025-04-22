package pers.god.demo.snowFlake;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

/**
 * @Author chuhao
 * @Date 2024/8/1
 * @Version 1.0.0
 */
public class SimpleCodeDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = Base64Utils.decodeFromString("W3sidXVpZCI6eyJhbGdvcml0aG0iOiJTTTQiLCJkZXN0cm95ZWQiOmZhbHNlLCJlbmNvZGVkIjoiYWxybmc1bHEyT2MyTHlJVE03QVc5QT09IiwiZm9ybWF0IjoiUkFXIiwia2V5SW5kZXgiOjB9fSx7ImVuY29kZSI6IkY2OUYxNzg2M0M3MTQxM0M5OEU3QUEzNTRCRjBDMTA2QzQ4QzI2QzU4NkI1MkIzNDkwMUUwQzM1MUM4NzIzRTYifV0=");
        System.out.println(new String(bytes, "UTF-8"));
    }

    /**
     * 随机出生日期
     *
     * @return
     */
    public static String randomBirthday() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, (int) (Math.random() * 60) + 1950);
        birthday.set(Calendar.MONTH, (int) (Math.random() * 12));
        birthday.set(Calendar.DATE, (int) (Math.random() * 31));

        StringBuilder builder = new StringBuilder();
        builder.append(birthday.get(Calendar.YEAR));
        long month = birthday.get(Calendar.MONTH) + 1;
        if (month < 10) {
            builder.append("0");
        }
        builder.append(month);
        long date = birthday.get(Calendar.DATE);
        if (date < 10) {
            builder.append("0");
        }
        builder.append(date);
        return builder.toString();
    }
}
