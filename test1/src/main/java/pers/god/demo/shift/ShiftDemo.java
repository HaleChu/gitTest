package pers.god.demo.shift;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author chuhao
 * @Date 2022/6/14
 * @Version 1.0
 */
public class ShiftDemo {

    public static void main(String[] args) {

        String s = "yyyy-MM-dd HH:mm:ss";
        System.out.println(s.length());

        String s1 = "2018-10-10";
        System.out.println(s1.substring(0, s1.lastIndexOf(".") == -1 ? s1.length() : s1.lastIndexOf(".")));

        String str = "code";
        System.out.println(Arrays.asList(str.split(",")));

    }

    @Test
    public void test1() {
        int year = LocalDate.now().getYear();
        String s = String.valueOf(year);
        System.out.println(year);
        System.out.println(s);
    }

    @Test
    public void test2() {
        int a = 10;
        int b = 5;
        String PARTY_FAIL_TO_STANDARD_MESSAGE_TEMPLATE = "%s 支部，您本年度的集体学习次数应完成 %s 次，实际完成 %s 次，还需要完成 %s 次！";
        System.out.printf((PARTY_FAIL_TO_STANDARD_MESSAGE_TEMPLATE) + "%n", "研究室", a, b, a - b);
    }

    @Test
    public void test3() throws ParseException {
        Date teachingDate = new Date();
        String endTime = "18:45";
        LocalDate localDate = teachingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String day = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String endTimeStr = day + " " + endTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date endDate = simpleDateFormat.parse(endTimeStr);
        System.out.println(endDate);
    }


}
