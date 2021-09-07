package other.exam.LittleRedBook;

import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/9/4
 */
public class Solution2 {

    public int partitionNumber(String text) {
        if (text.length() == 1) {
            return 1;
        }
        int res = 1;
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (isPartitionString(text, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isPartitionString(String text, int i, int j) {
        int left = i+1;
        int right = j;
        while (left < right) {
            String subleft = text.substring(i, left);
            String subright = text.substring(right, j + 1);
            if (subleft.equals(subright)) {
                return true;
            }
            left++;
            right--;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _text;
        try {
            _text = in.nextLine();
        } catch (Exception e) {
            _text = null;
        }

        res = new Solution2().partitionNumber(_text);
        System.out.println(String.valueOf(res));

    }
}
