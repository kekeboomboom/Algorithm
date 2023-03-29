package sort;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/7/30
 */
public class MergeSort {

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = Arrays.copyOfRange(a, 0, mid);
        int[] r = Arrays.copyOfRange(a, mid, n);

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            // 这l，r俩数组谁元素小，谁放前面
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        // 最终很可能有剩余的
        // 将l数组的剩下的元素放到a数组
        while (i < left) {
            a[k++] = l[i++];
        }
        // 将r数组的剩下的元素放到a数组
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4};
        MergeSort.mergeSort(actual, actual.length);
        System.out.println(Arrays.toString(actual));
    }
}
