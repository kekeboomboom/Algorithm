package zuo.chapter3;

import java.util.HashMap;

/**
 * @author keboom
 * @date 2021/5/21
 */
public class PreInTOPos {

    public int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    private int setPos(int[] p, int pi, int pj, int[] n, int ni, int nj, int[] s, int si, HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return si;
        }
        s[si--] = p[pi];
        int i = map.get(p[pi]);
        // 右树
        si = setPos(p, pj - nj + i + 1, pj, n, i + 1, nj, s, si, map);
        // 左树
        return setPos(p, pi + 1, pi + i - ni, n, ni, i - 1, s, si, map);
    }
}
