package zuo.chapter3;

/**
 * 给定一个整数 N，如果 N<1，代表空树结构，否则代表中序遍历的结果为{1,2,3,…，N}。请
 * 返回可能的二叉树结构有多少
 *
 * @author keboom
 * @date 2021/5/21
 */
public class NumTrees {

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }
}