package leetcode;

import java.util.Arrays;

/**
 * @author keboom
 * @date 2021/8/16
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[nums1.length];
        int indexM = 0;
        int indexN = 0;
        int curIndex=0;
        while (indexM < m || indexN < n) {
            if (indexM == m) {
                result[curIndex++] = nums2[indexN++];
            } else if (indexN == n) {
                result[curIndex++] = nums1[indexM++];
            } else if (nums1[indexM] > nums2[indexN]) {
                result[curIndex++] = nums2[indexN++];
            } else {
                result[curIndex++] = nums1[indexM++];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result[i];
        }
    }
}
