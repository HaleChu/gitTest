package pers.god.demo;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author chuhao
 * @Date 2024/9/13
 * @Version 1.0.0
 */
public class Mp4Demo {

    public static void main(String[] args) {
        List<String> dateConditionList = new ArrayList<>();
        for (int i = 7; i >= 0; i--) {
            dateConditionList.add(DateUtil.format(DateUtil.offsetMonth(new Date(), -i), "yyyy-MM"));
        }
        System.out.println(dateConditionList);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1); // 将当前年份加1
        calendar.set(Calendar.MONTH, 0); // 将月份设置为1月（0表示1月）
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 将天数设置为1

        String dateStr = String.format("%tF", calendar); // 获取yyyy-MM-dd格式的时间字符串
        System.out.println(dateStr);
    }
}
