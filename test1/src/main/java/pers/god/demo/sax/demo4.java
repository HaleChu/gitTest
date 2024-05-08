package pers.god.demo.sax;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @Author chuhao
 * @Date 2024/4/24
 * @Version 1.0.0
 */
public class demo4 {

    public static void main(String[] args) {
        System.out.println("今天:" + new Date());
        DateTime dateTime = DateUtil.offsetDay(new Date(), 5);
        System.out.println("5天后:" + dateTime);
        System.out.println(new Date().after(dateTime));
    }
}
