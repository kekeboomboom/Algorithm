package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/27
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        process(2 * n, 0, res, tmp, stack);
        return res;
    }

    /**
     * 我这个思路时基于回溯做的，我用tmp来存储状态，因此用过之后需要重置状态，而weiwei的题解用的递归栈，并不用tmp存储
     * 他的时深度优先遍历，而不是回溯。
     * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
     * 他的题解中解释了深度优先遍历和回溯的区别。
     * 我自己仍然是更具之前的题目，使用栈来判断所得出的结果是否符合条件，也就是我们再加入）之前先要判断之前是否有（与之匹配
     * 那么我们通过栈来进行判断，如果栈不为空那么就说明前面有（可以匹配。
     * 自然我这种思路比较麻烦，而且也比较巧妙吧。但巧妙不一定简洁。在复杂的基础上巧妙，那也还是复杂呀。。。
     * 我觉得weiwei的递归树很好，思路很纯正，根据这种思路不仅可以解决这个题，也可以解决其他题。
     * 而我这种属于灵光一闪吧，也不对我看weiwei第三种方法也是采用别人的，只不过我这种既有tmp又有stack两个回溯，所以看起来代码很多罢了。
     *
     * @param len
     * @param index
     * @param res
     * @param tmp
     * @param stack
     */
    private void process(int len, int index, List<String> res, StringBuilder tmp, LinkedList<Character> stack) {
        if (index == len) {
            res.add(new String(tmp));
            return;
        }
        // 如果左括号数量不大于n
        if (stack.size() < len - index) {
            tmp.append('(');
            stack.push(')');
            process(len, index + 1, res, tmp, stack);
            tmp.deleteCharAt(tmp.length() - 1);
            stack.pop();
        }
        // 栈不为空，也就是说左括号一定有多出来的能跟右括号匹配
        if (!stack.isEmpty()) {
            tmp.append(')');
            stack.pop();
            process(len, index + 1, res, tmp, stack);
            tmp.deleteCharAt(tmp.length() - 1);
            stack.push(')');
        }
    }


    /**
     * 使用深度搜索，那么写出递归树
     * weiwei哥使用的左右括号的个数来判断
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        process2("", n, n, res);
        return res;
    }

    /**
     * 这个string只要使用+，那么就改变了一个string，所以每一层递归栈状态都是不一样的，因此这是dfs而不是回溯
     * 下面我们的process3方法使用stringbuilder，这时我们就要回溯了，因为stringbuilder添加一个字符并不会变引用
     * 所以需要恢复状态
     *
     * @param tmp
     * @param left
     * @param right
     * @param res
     */
    private void process2(String tmp, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(tmp.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            process2(tmp + "(", left - 1, right, res);
        }
        if (right > 0) {
            process2(tmp + ")", left, right - 1, res);
        }
    }

    /**
     * 来看看使用stringbuilder，那么就要回溯了
     *
     * @param tmp
     * @param left
     * @param right
     * @param res
     */
    private void process3(StringBuilder tmp, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(tmp.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            tmp.append("(");
            process3(tmp, left - 1, right, res);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        if (right > 0) {
            tmp.append(")");
            process3(tmp, left, right - 1, res);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
