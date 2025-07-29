package pers.god.demo.file;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @Author chuhao
 * @Date 2025/2/8
 * @Version 1.0.0
 */
public class Demo2 {

    private static final String[] UNITS = {"B", "KB", "MB", "GB", "TB"};

    public static String convertBytes(long bytes) {
        if (bytes < 0) {
            throw new IllegalArgumentException("字节数不能为负数");
        }
        if (bytes == 0) {
            return "0 B";
        }

        int unitIndex = 0;
        double size = bytes;

        // 循环除以1024直到找到合适的单位
        while (size >= 1024 && unitIndex < UNITS.length - 1) {
            size /= 1024;
            unitIndex++;
        }

        // 根据是否为整数选择不同的格式
        return size == (long) size
                ? String.format("%d %s", (long) size, UNITS[unitIndex])
                : String.format("%.1f %s", size, UNITS[unitIndex]);
    }

    public static void main(String[] args) {
        DateTime tenDaysLater = DateUtil.offsetDay(new Date(), 14);
        System.out.println(tenDaysLater);
    }
}
