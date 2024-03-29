package pers.god.demo.number;

import java.text.NumberFormat;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/11/16
 */
public class PercentCalculation {

    public static void main(String[] args) {
        int a = 3;
        int b = 9;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        String result = numberFormat.format((float) a / (float) b * 100);
        System.out.println(result + "%");

        String s = "2023-09";
        System.out.println(s.substring(s.length() - 2));
        System.out.println(s.substring(0, s.length() - 2));
    }

}
