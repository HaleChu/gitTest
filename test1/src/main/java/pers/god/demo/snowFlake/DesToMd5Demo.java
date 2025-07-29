package pers.god.demo.snowFlake;

/**
 * @Author chuhao
 * @Date 2024/10/25
 * @Version 1.0.0
 */
public class DesToMd5Demo {

    public static void main(String[] args) {
        for (int i = 301; i <330; i++) {
            System.out.println(i);
        }

        String str = "二0二三年十一月三日";
        System.out.println(str.replace("二0二三", "2023").replace("十一月", "11月").replace("三日", "03日"));

        System.out.println();
    }
}
