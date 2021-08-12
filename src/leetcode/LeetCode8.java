package leetcode;

/**
 * @author keboom
 * @date 2021/8/11
 */
public class LeetCode8 {

    /**
     * 仿照Integer.parseInt
     * 这个代码不好理解，不安正常套路出牌
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        // 这个result是不停的减，一直是一个负数，跟我们正常思路相反，
        // 正常思路是判断正负，然后对结果不停的加，最后判断是否越界
        // 这个实现思路是不停的减，判断结果是否超出最小负数
        int result = 0;
        // true表示为负数，false表示为负数
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        // 取出空字符，相当于trim
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }

        // 去完空格，如果仍有字符
        if (i < len) {
            // 拿到第一个字符判断正负
            char firstChar = s.charAt(i);
            // 如果字符不是数字，可能为负号或者正号或其他不合法
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    return 0;
                }
                // 如果只有一个正负号，那不行
                if (len == 1) {
                    return 0;
                }
                i++;
            }

            multmin = limit / 10;
            while (i < len) {
                digit = Character.digit(s.charAt(i++), 10);
                // 如果不是数字，是字母或者其他的
                if (digit < 0) {
                    return negative ? result : -result;
                }
                /*下面这两个判断是跟
                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                而且由于他只计算负数，因此就不用判断正数的最大值，只需要判断负数的最小值
                很巧妙，它将正数最大值，和负数最小值放在一起判断！！！
                 */
                // 那么这一步实在比较十位的大小
                if (result < multmin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                // 对于这个判断，我们要知道result是负数，limit是负数，digit是正数
                //这一步是在比较个位的大小
                if (result < limit + digit) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        return negative ? result : -result;

    }

    /**
     * 更好理解的版本！！！！
     * @param s
     * @return
     */
    public int myAtoi2(String s) {
        int sign = 1;
        int res = 0;
        int m = s.length();
        int i = 0;
        // 跳过空字符
        while(i < m && s.charAt(i)==' '){
            i++;
        }
        int start = i;
        // 第一个字符判断正负，之后的字符判断如果为数字则先判断是否越界，不越界则加到结果中。
        for(; i < m; i++){
            char c = s.charAt(i);
            if(i==start && c=='+'){
                sign = 1;
            }else if(i==start && c=='-'){
                sign = -1;
            }else if(Character.isDigit(c)){
                int num = c-'0';
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }

                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                res = res*10+sign*num;
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("a4"));
//        System.out.println(Character.digit('a', 10));

        //对于是否是数字我们有api可用
        System.out.println(Character.isDigit('a'));
        System.out.println(Character.isDigit('2'));


//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }

}
