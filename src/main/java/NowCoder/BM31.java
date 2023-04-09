package NowCoder;

import java.util.ArrayList;

public class BM31 {

    boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        inorder(pRoot, list);
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i)!= list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode pRoot, ArrayList<Integer> list) {
        if (pRoot == null) {
            return;
        }
        inorder(pRoot.left, list);
        list.add(pRoot.val);
        if (pRoot.right!= null) {
            list.add(0);
        }
        inorder(pRoot.right, list);
    }
}
