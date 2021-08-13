package sort;

/**
 * @author keboom
 * @date 2021/8/13
 */
public class ThreeQuickSort {

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
}
