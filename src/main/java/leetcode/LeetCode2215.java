package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/2
 */
public class LeetCode2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        for (Integer integer : set1) {
            if (!set2.contains(integer)) {
                list1.add(integer);
            }
        }
        for (Integer integer : set2) {
            if (!set1.contains(integer)) {
                list2.add(integer);
            }
        }
        res.add(list1);
        res.add(list2);
        return res;
    }
}
