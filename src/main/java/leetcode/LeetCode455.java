package leetcode;

import zuo.chapter3.FindLargestTree;

import java.util.Arrays;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/30
 */
public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while (sIndex < s.length && gIndex < g.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
                sIndex++;
            } else {
                sIndex++;
            }
        }
        return gIndex;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2,3};
        LeetCode455 leetCode455 = new LeetCode455();
        int contentChildren = leetCode455.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
