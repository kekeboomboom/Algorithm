package sort;


import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/7/8
 */
public class QuickSort {

    /**
     * 这是以high为基准值的
     *
     * @param arr
     * @param low
     * @param high
     */
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition2(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

//    public int partition(int[] arr, int low, int high) {
//        int pivot = arr[high];
//        int i = (low - 1);
//        for (int j = low; j < high; j++) {
//            if (arr[j] <= pivot) {
//                i++;
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//
//        int temp = arr[i + 1];
//        arr[i + 1] = arr[high];
//        arr[high] = temp;
//
//        return i + 1;
//    }

    /**
     * 是我理解错了，并不是因为左右选择而导致算法不一样，无论左右都可以用快慢指针来partition
     * 下面就是以left为基准值，来进行快慢指针
     * @param arr
     * @param left
     * @param right
     * @return
     */
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

    /**
     * 这是以left为基准值的
     * @param nums
     * @param left
     * @param high
     */
//    public static void quickSort2(int[] nums, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int i = left - 1;
//        int j = right + 1;
//        int pivot = nums[left];
//        while (i < j) {
//            while (nums[++i] < pivot);
//            while (nums[--j] > pivot);
//            if (i < j) {
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//            }
//        }
//        quickSort2(nums, left, j);
//        quickSort2(nums, j + 1, right);
//    }

    /**
     * 这原来叫三路快排，就是为了数组中存在大量重复元素，而设计的
     * 不过我的实现有问题！！！
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 循环不变量定义
        // all in [left + 1, lt]
        // all in [lt + 1, i)
        // all in [gt, right]
        int pivot = arr[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            if (arr[i] > arr[pivot]) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i] == arr[pivot]) {
                i++;
            } else {
                gt--;
                swap(arr, i, gt);
            }
        }
        swap(arr, left, lt);
        quickSort(arr, left, lt - 1);
        quickSort(arr, gt, right);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void main(String[] args) {
        int[] arr= {8,9,4,5,6,5,5,6,3,1,1,5,2,7};
        new QuickSort().sort(arr, 0, arr.length - 1);
//        QuickSort.quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
