package leetcode;

import java.util.*;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/4
 */
public class LeetCode1657 {

    /**
     * 首先两个单词长度一样。
     * 计算每个单词每个字符的出现次数，得到一个集合。如果两个集合完全一样，那么返回true
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char key = word1.charAt(i);
            if (map1.containsKey(key)) {
                map1.put(key, map1.get(key) + 1);
            } else {
                map1.put(key, 1);
            }
        }
        for (int i = 0; i < word2.length(); i++) {
            char key = word2.charAt(i);
            if (map2.containsKey(key)) {
                map2.put(key, map2.get(key) + 1);
            } else {
                map2.put(key, 1);
            }
        }
        Set<Character> characters1 = map1.keySet();
        Set<Character> characters2 = map2.keySet();
        Collection<Integer> values1 = map1.values();
        Collection<Integer> values22 = map2.values();
        ArrayList<Integer> values2 = new ArrayList<>(values22);
        if (characters1.size() != characters2.size()) {
            return false;
        }
        characters1.forEach(item -> characters2.remove(item));
        if (characters2.size() != 0) {
            return false;
        }
        if (values1.size() != values2.size()) {
            return false;
        }
        values1.forEach(item->values2.remove(item));
        if (values2.size() == 0) {
            return true;
        }
        return false;
    }

    // 此题的优化点，当然来说是对我当前的代码的优化点。我这里分别把key和value取出来对比。以此来确定key和value完全一样。
    // 我们可以通过创建两个26长度的数组，来分别统计每个字母的词频。然后保证这两个数组一模一样就说明答案为true。
    public static void main(String[] args) {
        LeetCode1657 leetCode1657 = new LeetCode1657();
        boolean b = leetCode1657.closeStrings("abc", "bca");
        System.out.println(b);
    }
}
