package NowCoder;

import java.util.ArrayList;

public class BM23 {

    public int[] preorderTraversal(TreeNode root) {
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
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}
