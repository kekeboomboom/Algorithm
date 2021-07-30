package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author keboom
 * @date 2021/7/27
 */
public class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());

    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String,List<String>> result = new HashMap<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })));

        System.out.println(result);

        HashSet<String> result2 = new HashSet<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).keySet());

        System.out.println(result2);

        List<List<String>> result3 = new LeetCode49().groupAnagrams(strs);
        System.out.println(result3);
    }
}
