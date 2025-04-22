package pers.god.demo.nio;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @Author chuhao
 * @Date 2025/3/24
 * @Version 1.0.0
 */
public class Demo1 {

    public static void main(String[] args) {
        DateTime beginQuarter = DateUtil.offsetMonth(DateUtil.beginOfYear(new Date()), (1 - 1) * 3);
        DateTime endQuarter = DateUtil.offsetDay(DateUtil.offsetMonth(DateUtil.beginOfYear(new Date()), 1 * 3), -1);
        System.out.println(beginQuarter);
        System.out.println(endQuarter);
    }
}
