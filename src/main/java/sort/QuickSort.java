package sort;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

/**
 * @author keboom
 * @date 2021/7/8
 */
public class QuickSort {

    /*
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition2(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }


    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    public int partition2(int[] arr, int left, int right) {
        int pivot = arr[left];
        int j = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, left, j);
        return j;
    }


     */


    public static void main(String[] args) {
        int[] arr= {8,9,4,5,6,5,5,6,3,1,1,5,2,7};
//        new QuickSort().sort(arr, 0, arr.length - 1);
//        QuickSort.quickSort2(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

        /*
        double a = 5.3564;
        BigDecimal bigDecimal = new BigDecimal(a).setScale(3, RoundingMode.HALF_UP);
        System.out.println(bigDecimal);

        double doubleValue = bigDecimal.doubleValue();
        System.out.println(doubleValue);

         */

        new QuickSort().quickSort222(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // 就记这个快排的代码吧，简洁！！
    // 最佳时间复杂度 o(n) , 最差 o(nlogn)
    public int[] quickSort222(int[] nums, int left, int right) {
        if (left < right) {
            int i = partition222(nums, left, right);

            quickSort222(nums, left, i - 1);
            quickSort222(nums, i + 1, right);
        }
        return nums;
    }

    private int partition222(int[] nums, int left, int right) {
        int privot = nums[left];
        int i = left;
        for (int j = left; j <= right; j++) {
            if (nums[j] < privot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, i);
        return i;
    }
    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
