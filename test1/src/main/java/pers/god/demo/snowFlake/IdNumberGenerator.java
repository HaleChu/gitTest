package pers.god.demo.snowFlake;

import java.util.Random;

/**
 * @Author chuhao
 * @Date 2024/7/25
 * @Version 1.0.0
 */
public class IdNumberGenerator {

    public static void main(String[] args) {
        // 生成随机的身份证号码
        Random random = new Random();
        int[] coefficient = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String[] idCardNumberArray = new String[18];
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            int number = random.nextInt(10);
            sum += number * coefficient[i];
            idCardNumberArray[i] = String.valueOf(number);
        }
        int remainder = sum % 11;
        String lastNumber = String.valueOf(remainder);
        idCardNumberArray[17] = remainder == 10 ? "x" : lastNumber;
        String idCardNumber = String.join("", idCardNumberArray);
        System.out.println("随机生成的身份证号码为:" + idCardNumber);
    }
}

