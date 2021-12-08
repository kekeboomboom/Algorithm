package leetcode;

/**
 * @author keboom
 * @date 2021/3/7
 */
public class LeetCode38 {
    public String countAndSay(int n) {
//        StringBuilder res = new StringBuilder();
//        StringBuilder tmp = new StringBuilder();
//        res = res.append(1);
//        int count = 0;
//        String cur="1";
//        for (int i = 2; i <= n; i++) {
//            while (res.capacity() != 0) {
//
//            }
//        }
//        return res.toString();

        // 我知道思路，可是代码实现真的菜呀

        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        res.append(1);
        int count = 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                while (i < res.length()-1 && res.charAt(i) == res.charAt(i + 1)) {
                    count++;
                    i++;
                }
                tmp.append(count).append(res.charAt(i));
            }
            res = tmp;
            tmp.delete(0,tmp.capacity()-1);
        }

        return res.toString();
    }
}
