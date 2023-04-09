package NowCoder;

public class BM30 {

    TreeNode preNode;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        inorder(pRootOfTree);
        return head;
    }

    private void inorder(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        inorder(pRootOfTree.left);
        pRootOfTree.left = preNode;
        if (preNode!= null) {
            preNode.right = pRootOfTree;
        }
        preNode = pRootOfTree;

        inorder(pRootOfTree.right);
    }
}
