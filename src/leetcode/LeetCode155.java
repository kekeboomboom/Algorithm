package leetcode;


import java.util.Stack;

/**
 * @author keboom
 * @date 2021/8/6
 */
public class LeetCode155 {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    public LeetCode155() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || x <= helper.peek()) {
            helper.add(x);
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            Integer pop = data.pop();
            if (pop == helper.peek()) {
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("stack is empty!");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("stack is empty!!");
    }
}
