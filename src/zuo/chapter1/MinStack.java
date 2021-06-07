package zuo.chapter1;

import java.util.Stack;

/**
 * @author keboom
 * @date 2021/5/21
 */
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= this.getmin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Integer value = stackData.pop();
        if (value == getmin()) {
            stackMin.pop();
        }
        return value;
    }

    private int getmin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stackMin.peek();
    }
}
