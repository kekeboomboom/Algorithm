package other.exam.TAL;

/**
 * @author keboom
 * @date 2021/8/8
 */
public class Solution2 {


    public String edit_string (String str, int k) {
        int len = str.length();
        k = k % len;
        String s1 = str.substring(0, k);
        String s2 = str.substring(k, len);
        return s2+s1;

    }

    public static void main(String[] args) {


    }
}
/*
"abcXYZdef",3
"XYZdefabc"

 */