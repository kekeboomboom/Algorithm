package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/25
 */
public class LeetCode332 {

    ArrayList<String> tmp = new ArrayList<>();
    List<String> result = new ArrayList<>();
    HashSet<Integer> used = new HashSet<>();
    /**
     * 这题首先我们基本上要找所有情况，然后从中选取字典序最大的。
     * 因此确定使用回溯法。
     * 在回溯方法中，我们需要确定：1.已经用过的车票。2.此轮寻找的起始站
     * 找到对应的起始站后，可以向下递归。
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        tmp.add("JFK");
        backtracking(tickets, "JFK");
        return result;
    }

    private boolean backtracking(List<List<String>> tickets, String originStation) {
        if (tmp.size() == tickets.size() + 1) {
            result = new ArrayList<>(tmp);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (used.contains(i) || !tickets.get(i).get(0).equals(originStation)) {
                continue;
            }
            if (i > 0 && ticketEqual(tickets.get(i - 1), tickets.get(i)) && !used.contains(i-1)) {
                continue;
            }
            used.add(i);
            String terminalStation = tickets.get(i).get(1);
            tmp.add(terminalStation);
            if (backtracking(tickets, terminalStation)) {
                return true;
            }
            tmp.remove(tmp.size() - 1);
            used.remove(i);
        }
        return false;
    }

    private boolean ticketEqual(List<String> t1, List<String> t2) {
        if (t1.get(0).equals(t2.get(0)) && t1.get(1).equals(t2.get(1))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode332 leetCode332 = new LeetCode332();
        ArrayList<List<String>> tickets = new ArrayList<>();
        ArrayList<String> t1 = new ArrayList<>();
        t1.add("MUC");
        t1.add("LHR");
        tickets.add(t1);
        ArrayList<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("MUC");
        tickets.add(t2);
        ArrayList<String> t3 = new ArrayList<>();
        t3.add("SFO");
        t3.add("SJC");
        tickets.add(t3);
        ArrayList<String> t4 = new ArrayList<>();
        t4.add("LHR");
        t4.add("SFO");
        tickets.add(t4);
        List<String> itinerary = leetCode332.findItinerary(tickets);
        System.out.println(itinerary.toString());
    }
}
