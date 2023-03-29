package NowCoder;

import java.util.ArrayList;
import java.util.LinkedList;

public class BM27 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> rootLIst = new ArrayList<>();
        rootLIst.add(pRoot.val);
        res.add(rootLIst);
        int layer = 1;
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            layer++;
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
            if (layer % 2 == 0) {
                for (int i = tmp.size() - 1; i >= 0; i--) {
                    integers.add(tmp.get(i).val);
                }
            } else {
                tmp.forEach(treeNode -> integers.add(treeNode.val));
            }
            res.add(integers);

            queue = tmp;
        }
        return res;
    }
}
