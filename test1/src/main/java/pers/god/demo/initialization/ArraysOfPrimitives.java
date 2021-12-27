package pers.god.demo.initialization;

import java.util.Arrays;
import java.util.Random;

/**
 * @author chuhao
 * @version 1.0.0
 * @date 2021/12/11
 */
public class ArraysOfPrimitives {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] += 1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println("a1[" + i + "]=" + a1[i]);
        }

        int[] b;
        Random random = new Random(47);
        int i = random.nextInt(20);
        System.out.println("随机数：" + i);
        b = new int[random.nextInt(20)];
        System.out.println("length of b = " + b.length);
        System.out.println(Arrays.toString(b));
    }
}
