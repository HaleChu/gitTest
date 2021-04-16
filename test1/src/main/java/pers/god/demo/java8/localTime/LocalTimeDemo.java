package pers.god.demo.java8.localTime;

import java.time.*;
import java.util.Date;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/10/28
 */
public class LocalTimeDemo {

    public static void main(String[] args) {
        /*LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);*/

        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        /*System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());*/

        System.out.println("getYear "+localDateTime.getYear());
        System.out.println("getMonth "+localDateTime.getMonth());
        System.out.println("getMonthValue "+localDateTime.getMonthValue());
        System.out.println("getDayOfYear "+localDateTime.getDayOfYear());
        System.out.println("getDayOfMonth "+localDateTime.getDayOfMonth());
        System.out.println("getDayOfWeek "+localDateTime.getDayOfWeek());
        System.out.println("getHour "+localDateTime.getHour());
        System.out.println("getMinute "+localDateTime.getMinute());
        System.out.println("getSecond "+localDateTime.getSecond());
    }
}
