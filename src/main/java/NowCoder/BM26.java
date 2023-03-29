package NowCoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BM26 {


    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> rootLIst = new ArrayList<>();
        rootLIst.add(root.val);
        res.add(rootLIst);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if (treeNode.left != null) {
                    tmp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tmp.add(treeNode.right);
                }
            }
            if (tmp.isEmpty()) {
                break;
            }
            ArrayList<Integer> integers = new ArrayList<>();
            tmp.forEach(t->integers.add(t.val));
            res.add(integers);

            queue = tmp;
        }
        return res;
    }
}
