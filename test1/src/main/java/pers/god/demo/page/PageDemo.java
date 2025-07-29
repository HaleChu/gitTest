package pers.god.demo.page;

/**
 * @Author chuhao
 * @Date 2024/5/15
 * @Version 1.0.0
 */
public class PageDemo {

    public static void main(String[] args) {
        int batchSize = 200;
        int total = 13846;
        int pages = (int) Math.ceil(total / (float) batchSize);
        for (int i = 1; i <= pages; i++) {
            System.out.println("第" + i + "页");
            System.out.println("页面大小" + batchSize);
        }
    }
}
