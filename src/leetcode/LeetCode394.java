package leetcode;//package leetcode;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
///**
// * @author keboom
// * @date 2021/2/23
// */
//public class LeetCode394 {
//    public String decodeString(String s) {
//        StringBuilder res = new StringBuilder();
//        int multi = 0;
//        StringBuilder str = new StringBuilder();
//        Deque<Integer> stack_multi = new LinkedList<>();
//        Deque<String> stack_str = new LinkedList<>();
//        for (Character c : s.toCharArray()) {
//            if (c == '[') {
//                stack_multi.addLast(multi);
////                stack_str.addLast(str);
//                multi = 0;
////                res = new StringBuilder();
//            } else if (c == ']') {
//                StringBuilder tmp = new StringBuilder();
//                int cur_multi = stack_multi.removeLast();
//                for (int i = 0; i < cur_multi; i++) {
//                    tmp.append(res);
//                }
//                res = new StringBuilder(stack_res.removeLast() + tmp);
//            } else if (c >= '0' && c <= '9') {
//                multi = c - '0';
//            } else {
//                str.append(c);
//            }
//        }
//        return res.toString();
//
//    }
//
//    public static void main(String[] args) {
//        String s = "3[a]4[bc]";
//        LeetCode394 leetCode394 = new LeetCode394();
//        System.out.println(leetCode394.decodeString(s));
//    }
//}
