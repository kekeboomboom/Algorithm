package zuo.chapter1;

import java.util.Stack;

/**
 * 由两个栈组成的队列
 * @author keboom
 * @date 2021/5/21
 */
public class TwoStackTOQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public TwoStackTOQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void offer(int newNum) {
        stack1.push(newNum);
    }

    public int poll() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer value = stack1.pop();
                stack2.push(value);
            }
        }
        Integer res = stack2.pop();
        return res;
    }
}
