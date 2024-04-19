package leetcode;

import java.util.HashMap;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/18
 */
public class LeetCode13 {


    /**
     * 构造一个 map，存放罗马数字与正常数字的映射，遍历字符串，判断是哪种罗马数字
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int sum = 0;
        int i = 0;
        while (i<s.length()){
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                sum += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                sum += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return sum;
    }
}
