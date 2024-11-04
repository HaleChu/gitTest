package pers.god.demo.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @Author chuhao
 * @Date 2024/10/23
 * @Version 1.0.0
 */
public class test {

    public static void main(String[] args) {
        int[] its = {23, 54, 21, 123, 16, 4, 2, 234, 153, 87, 56, 98};
        bubbleSort(its);
        System.out.println(Arrays.toString(its));
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
