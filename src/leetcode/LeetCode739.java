package leetcode;

/**
 * @author keboom
 * @date 2021/3/7
 */
public class LeetCode739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i+1; j < T.length; j++) {
                if (j==T.length-1){
                    ans[i]=0;
                }
                if (T[j] > T[i]){
                    ans[i]=j-i;
                    break;
                }
            }

        }
        return ans;
    }
}
