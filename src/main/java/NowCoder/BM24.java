package NowCoder;

import java.util.ArrayList;

public class BM24 {

    public int[] inorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        preOrder(root, res);
        int[] arrayRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arrayRes[i] = res.get(i);
        }
        return arrayRes;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        preOrder(root.left, res);
        res.add(root.val);
        preOrder(root.right, res);
    }
}
