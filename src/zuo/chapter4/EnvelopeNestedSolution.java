package zuo.chapter4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author keboom
 * @date 2021/4/19
 * 信封嵌套问题
 */
public class EnvelopeNestedSolution {
    public class Envelope{
        private int len;
        private int wid;

        public Envelope(int len, int wid) {
            this.len = len;
            this.wid = wid;
        }
    }

    // 将信封按长度从小到大排序，如果长度相等则按宽度从大到小排序。
    public class EnvelopeComparator implements Comparator<Envelope> {
        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.len != o2.len ? o1.len - o2.len : o2.wid - o1.wid;
        }
    }
    public Envelope[] getSortedEnvelopes(int[][] matrix) {
        Envelope[] res = new Envelope[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            res[i] = new Envelope(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(res, new EnvelopeComparator());
        return res;
    }

    // 排好序后，比如我们选择第x个信封，由于长度为从小到大，所以我们需要往左找。
    // 往左找有两种情况，一种长度相等，一种长度更小。
    // 长度相等，由于宽度从大到小，则找宽度的最长递增子序列
    // 长度更小，也是找最长递增子序列
    public int maxEnvelopes(int[][] matrix) {
        Envelope[] envelopes = getSortedEnvelopes(matrix);
        // to do二分法做最长递增子序列
        return 1;
    }
}
