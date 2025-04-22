package pers.god.demo.snowFlake;

import java.util.Random;

/**
 * @Author chuhao
 * @Date 2024/12/24
 * @Version 1.0.0
 */
public class ChineseNameGenerator {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getRandomChineseName());
        }
    }

    public static String getRandomChineseName() {
        String[] surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈"};
        String[] name = {"伟", "刚", "勇", "毅", "俊", "峰", "强", "军", "平", "杰"};

        Random random = new Random();
        int surnameIndex = random.nextInt(surname.length);
        int nameIndex1 = random.nextInt(name.length);
        int nameIndex2 = random.nextInt(name.length);

        return surname[surnameIndex] + name[nameIndex1] + name[nameIndex2];
    }
}
