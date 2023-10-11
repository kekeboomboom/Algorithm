package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/28
 */
public class LeetCode501 {

    HashSet<Integer> set = new HashSet<>();
    int maxCount = 0;
    int curCount = 0;
    int pre = Integer.MAX_VALUE;
    public int[] findMode(TreeNode root) {

        inorder(root);
        int[] res = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int i=0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (root.val == pre) {
            curCount++;
        } else {
            curCount = 1;
        }
        if (curCount == maxCount) {
            set.add(root.val);
        } else if (curCount > maxCount) {
            set.clear();
            set.add(root.val);
            maxCount = curCount;
        }
        pre = root.val;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(2);

        LeetCode501 leetCode501 = new LeetCode501();
        int[] mode = leetCode501.findMode(treeNode1);


    }

}
