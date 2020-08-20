package pers.god.demo.algorithm;

/**
 * @Author GodChu
 * @Date 2020/8/18
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {23, 54, 21, 123, 16, 4, 2, 234, 153, 87, 56, 98};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
