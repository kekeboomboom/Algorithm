package leetcode.tree;

import java.util.LinkedList;
import org.junit.Test;
import common.TreeNode;

/**
 *
 * @author keboom
 * @date 2021/12/8
 */
public class Demo1 {

  @Test
  public void test() {
    TreeNode testTree = TreeNode.getTestTree();
//    pre(testTree);
//    inorder(testTree);
    pos(testTree);
  }

  public void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (!stack.isEmpty() || root != null) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode pop = stack.pop();
        System.out.println(pop.value);
        root = pop.right;
      }
    }
  }

  public void pos(TreeNode root) {
    if (root == null) {
      return;
    }
    LinkedList<TreeNode> stack1 = new LinkedList<>();
    LinkedList<TreeNode> stack2 = new LinkedList<>();
    stack1.push(root);
    while (!stack1.isEmpty()) {
      TreeNode pop = stack1.pop();
      stack2.push(pop);
      if (pop.left != null) {
        stack1.push(pop.left);
      }
      if (pop.right != null) {
        stack1.push(pop.right);
      }
    }
    while (!stack2.isEmpty()) {
      System.out.println(stack2.pop().value);
    }
  }



}
