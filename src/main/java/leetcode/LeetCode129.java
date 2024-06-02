package leetcode;

import java.util.ArrayList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/6/2
 */
public class LeetCode129 {

    /**
     * 通过遍历得到所有数字，然后遍历数字求和
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        getNumbers(root, list,new StringBuilder());
        int sum=0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private void getNumbers(TreeNode root, ArrayList<String> list, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        getNumbers(root.left,list,sb);
        getNumbers(root.right,list,sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
