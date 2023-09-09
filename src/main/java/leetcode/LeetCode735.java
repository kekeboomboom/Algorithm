package leetcode;

import SwordPointToOffer.array.Offer4;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/9/6
 */
public class LeetCode735 {

    /**
     * 消消乐
     * 栈顶元素与即将入栈元素作比较，
     * 如果栈顶元素与即将入栈元素同符号，那么直接入栈
     * 如果符号相反，则要判断谁爆炸。如果栈顶元素绝对值小，那么移除栈顶，将即将入栈的元素加入栈中
     * 如果栈顶元素大，那么不入栈
     * 如果相等，那么移除栈顶，且即将入栈的也不入栈了
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (stack.size() == 0 || stack.peek()< 0 || (stack.peek()>0 && asteroid>0)) {
                stack.push(asteroid);
            } else if (Math.abs(stack.peek()) > Math.abs(asteroid)) {

            } else if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                stack.pop();
                while (stack.size()>0 && stack.peek()>0&&Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                }
                if (stack.size() == 0 || stack.peek()<0) {
                    stack.push(asteroid);
                    continue;
                }
                if (Math.abs(stack.peek()) > Math.abs(asteroid)) {
                    continue;
                }
                if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                }
                stack.push(asteroid);
            } else {
                stack.pop();
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length-1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode735 leetCode735 = new LeetCode735();
        int[] aster = {10,2,-5};
        int[] ints = leetCode735.asteroidCollision(aster);
        System.out.println(Arrays.toString(ints));
    }
}
