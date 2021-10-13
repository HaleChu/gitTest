package pers.god.demo.algorithm;

/**
 * 快速排序
 *
 * @Author GodChu
 * @Date 2020/8/18
 */
public class FastSort {

    public static void main(String[] args) {
        int[] arr = {23, 54, 21, 123, 16, 4, 2, 234, 153, 87, 56, 98};
//        bubbleSort1(arr);
//        bubbleSort2(arr);
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    /**
     * BUBBLE_SORT_1
     */
    private static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * BUBBLE_SORT_2
     */
    private static void bubbleSort2(int[] arr) {
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }
        } while (flag);
    }

    /**
     * QUICK_SORT
     */
    private static void quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (arr[j] > pivot) {
                j--;
            }
            while (arr[i] < pivot) {
                i++;
            }
            if (arr[i] == arr[j]) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (i - 1 > start) {
                quickSort(arr, start, i - 1);
            }
            if (j + 1 < end) {
                quickSort(arr, j + 1, end);
            }

        }
    }

}
