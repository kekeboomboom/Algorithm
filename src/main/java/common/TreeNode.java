package common;

/**
 * @author keboom
 * @date 2021/4/30
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 这是一个普通的二叉树
     *          10
     *     12        15
     *  4     7    5    18
     * @return
     */
    public static TreeNode getTestTree() {
        TreeNode treeNode10 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode15 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode18 = new TreeNode(3);

        treeNode10.left = treeNode12;
        treeNode10.right = treeNode15;
        treeNode12.left = treeNode4;
        treeNode12.right = treeNode7;
        treeNode15.left = treeNode5;
        treeNode15.right = treeNode18;

        return treeNode10;
    }

    /**
     * 这是一个二叉搜索树
     *          10
     *     5          15
     *  4     7    12    18
     * @return
     */
    public static TreeNode getBSTTree() {
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode18 = new TreeNode(18);

        treeNode10.left = treeNode5;
        treeNode10.right = treeNode15;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode7;
        treeNode15.left = treeNode12;
        treeNode15.right = treeNode18;

        return treeNode10;
    }
}
