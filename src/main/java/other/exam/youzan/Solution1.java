package other.exam.youzan;

/**
 * @author keboom
 * @date 2021/8/21
 */
public class Solution1 {

    public boolean isMatch(String s, String p) {
        StringBuilder sb = new StringBuilder(s+"-");
        char[] pchars = p.toCharArray();
        for (int i = 0; i < pchars.length-1; i++) {
            if (pchars[i] == '.' && pchars[i + 1] == '*') {
                return true;
            } else if (pchars[i] == '.') {
                sb.deleteCharAt(0);
                continue;
            } else if (pchars[i + 1] != '*') {
                if (pchars[i] == sb.charAt(0)) {
                    sb.deleteCharAt(0);
                } else {
                    return false;
                }
            } else if (pchars[i + 1] == '*') {
                if (pchars[i] != sb.charAt(0)) {
                    continue;
                } else {
                    if (sb.charAt(1) != sb.charAt(0)) {
                        return false;
                    } else {
                        while (pchars[i] == sb.charAt(0)) {
                            sb.deleteCharAt(0);
                        }
                    }
                }
            } else if (pchars[i] == '*') {
                continue;
            }
            if (i == pchars.length - 2) {
                return sb.length() == 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("123");
        System.out.println(sb.charAt(0));
    }
}
