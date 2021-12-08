package SwordPointToOffer;

import java.util.LinkedList;

/**
 * @author keboom
 * @date 2021/7/23
 */
public class Offer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        int popIndex = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();

    }
}
