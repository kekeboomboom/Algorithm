package SwordPointToOffer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/22
 */
public class Offer32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                root = queue.poll();
                tmp.add(root.value);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }














    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                root = queue.poll();
                if (res.size() % 2 == 0) {
                    tmp.offerLast(root.value);
                } else {
                    tmp.offerFirst(root.value);
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
