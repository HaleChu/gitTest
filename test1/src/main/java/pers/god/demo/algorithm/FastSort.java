package pers.god.demo.algorithm;

/**
 * @Author GodChu
 * @Date 2020/8/18
 */
public class FastSort {

    public static void main(String[] args) {
        int[] arr = {23, 54, 21, 123, 16, 4, 2, 234, 153, 87, 56, 98};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i = low, j = high;
        int temp;
        if (i < j) {
            temp = arr[i];
            while (arr[j] > temp) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] < temp) {
                i++;
            }
            arr[j] = arr[i];
            arr[i] = temp;
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }
}
