package zuo.chapter3;

import java.util.HashMap;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 *
 * @author keboom
 * @date 2021/5/9
 */
public class SumMaxPath {

    public int getMaxLength(TreeNode head, int sum) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);
        return preOrder(head, sum, 0, 1, 0, sumMap);
    }

    private int preOrder(TreeNode head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
        if (head == null) {
            return maxLen;
        }
        int curSum = preSum + head.value;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        if (sumMap.containsKey(curSum - sum)) {
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
        }
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);
        // 在这里要删除，我认为可能是因为二叉树的结构，就是说遍历一个二叉树从头到尾会有很多路径
        // 也就是说同一level上可以有多个curSum
        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }
        return maxLen;
    }
}
