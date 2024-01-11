package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/9
 */
public class LeetCode402 {

    /**
     * 这题的关键点，就是你遍历当前的元素，来判断当前元素的前一个元素的保留和移除。---因此说是贪心
     *
     * 第二个说栈，其实就是只操作字符串结尾，自然就像栈而已。
     *
     * 我觉得这不是一个好题目。你必须想出贪心才行。可是这道题的贪心非常不好想。或者说贪心的题目，本就是碰运气的。
     * 如果没有明确的数学证明，那么贪心不就是碰运气么。
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if(num.length() == k)       return "0";

        StringBuilder stack = new StringBuilder();

        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            while(k > 0 && stack.length() != 0 && stack.charAt(stack.length() - 1) > ch){
                // stack pop
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            if(ch == '0' && stack.length() == 0)    continue;

            // stack push
            stack.append(ch);
        }
        String res = stack.substring(0, stack.length() - k).toString();
        return res.length() == 0 ? "0" : res;
    }

    private boolean frontZero(StringBuilder sb, int k) {
        for (int i = 0; i <= k; i++) {
            if (sb.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }
}
