package zuo.chapter3;

import common.TreeNode;

/**
 * @author keboom
 * @date 2021/5/17
 */
public class IsPostArray {

    public boolean isPostArray(int[] arr) {
        if (arr == null && arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    /**
     * arr=[2,1,3,6,5,7,4]
     * 比如end为4，则less为3，more为6
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        // 就是说没有左子树或者没有右子树，那么重新判断
        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }
        // 如果less和more不是相邻的，则false
        if (less != more - 1) {
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }


    /**
     * 根据数组重构搜索二叉树
     * @param posArr
     * @return
     */
    public TreeNode posArrayToBST(int[] posArr) {
        if (posArr == null) {
            return null;
        }
        return posToBST(posArr, 0, posArr.length - 1);
    }

    private TreeNode posToBST(int[] posArr, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode head = new TreeNode(posArr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (posArr[end] > posArr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        head.left = posToBST(posArr, start, less);
        head.right = posToBST(posArr, more, end - 1);
        return head;
    }
}
