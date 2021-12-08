package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/16
 */
public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, merge, 0, nums1.length);
        System.arraycopy(nums2, 0, merge, nums1.length, nums2.length);

        Arrays.sort(merge);

        double res = 0;
        if (merge.length % 2 == 0) {
            double i1 = merge[merge.length / 2 - 1];
            double i2 = merge[merge.length / 2];
            res = (i1 + i2) / 2;
        } else {
            res = merge[merge.length / 2];
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
