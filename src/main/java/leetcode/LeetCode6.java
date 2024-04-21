package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/4/19
 */
public class LeetCode6 {

    /**
     * 通过模拟的方式去做。
     * 方向分为上下。
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        ArrayList<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Character> characters = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                characters.add('0');
            }
            lists.add(characters);
        }
        // down or up
        String direction = "down";
        int x = 0;
        int y = 0;
        int index = 0;
        while (index < s.length()) {
            lists.get(x).set(y, s.charAt(index));
            if (x == numRows - 1) {
                direction = "up";
            } else if (x == 0) {
                direction = "down";
            }
            if (direction.equals("down")) {
                x += 1;
            } else {
                y += 1;
                x -= 1;
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lists.size(); i++) {
            for (Character c : lists.get(i)) {
                if (c.equals('0')) {
                    continue;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LeetCode6 leetCode6 = new LeetCode6();
        leetCode6.convert("PAYPALISHIRING", 4);

    }
}
