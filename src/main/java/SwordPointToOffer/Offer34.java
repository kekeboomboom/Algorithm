package SwordPointToOffer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/7/22
 */
public class Offer34 {

    List<List<Integer>> res;
    List<Integer> tmp;
    int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        process(root, target,sum);
        return res;
    }

    private void process(TreeNode root, int target,int sum) {
        if (root == null) {
            return;
        }
        tmp.add(root.value);
        sum += root.value;
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(tmp));
        }
        process(root.left,target,sum);
        process(root.right,target,sum);
        sum -= root.value;
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);
        tmp.add(2);
        List<Integer> lest = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            lest.add(tmp.get(i));
        }
        res.add(lest);
//        res.add(new ArrayList<>(tmp));
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }




/*
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
 */


    List<List<Integer>> res2 = new LinkedList<>();
    LinkedList<Integer> tmp2 = new LinkedList<>();

    public List<List<Integer>> pathSum2(TreeNode root, int target) {
        if (root == null) {
            return new LinkedList<>();
        }
        process2(root, target);
        return res2;
    }

    private void process2(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target -= root.value;
        tmp2.add(root.value);
        if (target == 0 && root.left == null && root.right == null) {
            res2.add(new LinkedList<>(tmp2));
        }
        process2(root,target);
        process2(root,target);
        tmp2.removeLast();
    }
}
