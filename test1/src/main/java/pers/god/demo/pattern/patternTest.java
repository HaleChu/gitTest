package pers.god.demo.pattern;

import java.util.regex.Pattern;

/**
 * @Author chuhao
 * @Date 2023/10/30
 * @Version 1.0.0
 */
public class patternTest {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^([\\u4e00-\\u9fa5_a-zA-Z0-9\\-]+)\\.([\\u4e00-\\u9fa5_a-zA-Z0-9\\-]+)$");
        Pattern pattern1 = Pattern.compile("^([\\u4e00-\\u9fa5_a-zA-Z0-9\\-]+)([(][\\u4e00-\\u9fa5_a-zA-Z0-9\\-]+[)])\\.([\\u4e00-\\u9fa5_a-zA-Z0-9\\-]+)");
        String str = "工作经历简历.曾在单位起始日期";
        System.out.println(pattern.matcher(str).matches());
        System.out.println(pattern1.matcher(str).matches());
    }
}
