package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/26
 */
public class LeetCode443 {

    /**
     * 因为它只是要一个数字，因此不需要新建数组，只需要有限的几个数字就可以记录
     * 对于就判断数字长度的，可以转成字符串判断长度，也可以直接判断数字大小。因为题目说了数组最大2000长度，因此通过数字大小来判断长度也简单。
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        char curChar = chars[0];
        int curCount = 1;
        int result = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == curChar) {
                curCount++;
            } else {
                int numberLength = getNumberLength(curCount);
                result += numberLength + 1;
                curChar = chars[i];
                curCount = 1;
            }
        }
        int numberLength = getNumberLength(curCount);
        result += numberLength + 1;
        return result;
    }

    /**
     * 因为题目给了，chars长度小于等于2000
     *
     * @param nums
     * @return
     */
    private int getNumberLength(int nums) {
        if (nums < 10) {
            return 1;
        } else if (nums < 100) {
            return 2;
        } else if (nums < 1000) {
            return 3;
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {
        LeetCode443 leetCode443 = new LeetCode443();
        char[] chars = {'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',};
        int compress = leetCode443.compress(chars);

        System.out.println(compress);
    }
}
