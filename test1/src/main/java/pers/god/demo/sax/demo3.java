package pers.god.demo.sax;

import java.util.regex.Pattern;

/**
 * @Author chuhao
 * @Date 2024/4/10
 * @Version 1.0.0
 */
public class demo3 {

    public static void main(String[] args) {
        String pattern = "\\d{4}.(([0]+[1-9])|([1]+[0-2]))";
        String str = "1989.09";
        System.out.println(Pattern.matches(pattern, str));

        String a = "A01.xml";
        System.out.println(a.substring(0, a.indexOf(".")));
    }
}
