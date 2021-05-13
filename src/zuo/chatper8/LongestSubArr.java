package zuo.chatper8;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 未排序数组中累加和为给定值的最长子数组系列问题
 *
 * 总结：我感觉只要是sum的问题，都会涉及到map
 *
 * @author keboom
 * @date 2021/5/9
 */
public class LongestSubArr {

    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    /**
     * 补充问题：求数组正数负数个数相等的最长子数组长度
     * 怎么才能正数负数个数相等呢？把正数变为1，负数变为-1，两者之和为0不就是个数相等了
     *
     * @param arr
     * @return
     */
    public static int maxLength2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            arr[i] = arr[i] < 0 ? -1 : 1;
        }
        int sum = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - 0)) {
                len = Math.max(i - map.get(sum - 0), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    /**
     * 其中元素只是1或者0,求0和1个数相等的最长子数组
     * 把0换成-1,和为零不就是个数相等了
     *
     * @param arr
     * @return
     */
    public static int maxLength3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? -1 : arr[i];
        }
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - 0)) {
                len = Math.max(i - map.get(sum - 0), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, -3, 0, -3, 5};
//        int res = maxLength(arr, 2);
//        System.out.println(res);
//        int[] arr = {1, 1, 1, 1, 1, -1, -1, 0};
//        int res = maxLength2(arr);
//        System.out.println(res);
        int[] arr = {1, 1, 1, 1, 0, 1, 0, 0, 0};
        int res = maxLength3(arr);
        System.out.println(res);

    }
}
