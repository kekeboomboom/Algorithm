package other.exam.meituan;

import java.util.*;

/**
 * @author keboom
 * @date 2021/8/22
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(cards));

        Arrays.sort(cards);
        // 将用过的索引放到里面
        HashSet<Integer> set = new HashSet<>();
        List<ArrayList<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        process(cards, tmp, res,set);
        System.out.println(res.size());
        for (ArrayList<Integer> list : res) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    //在搞一个map吧，对于用过的值，放到map中，然后看contain不》
    private static void process(int[] cards, List<Integer> tmp, List<ArrayList<Integer>> res,HashSet<Integer> set) {
        if (set.size() == cards.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < cards.length; i++) {
            if (i - 1 >= 0 && cards[i - 1] == cards[i] && set.size() == 0) {
                continue;
            }
//            if (i - 1 >= 0 && cards[i - 1] == cards[i] && set.contains(i)) {
//                break;
//            }
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            tmp.add(cards[i]);
            process(cards,tmp,res,set);
            set.remove(i);
            tmp.remove(tmp.size() - 1);
        }
    }

}
