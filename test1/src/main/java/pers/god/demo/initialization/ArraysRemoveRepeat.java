package pers.god.demo.initialization;

import java.util.Arrays;

/**
 * @author chuhao
 * @version 1.0.0
 * @date 2021/12/11
 */
public class ArraysRemoveRepeat {

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 4, 5, 5};
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] == a[j]) {
                    i = j;
                    i--;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
