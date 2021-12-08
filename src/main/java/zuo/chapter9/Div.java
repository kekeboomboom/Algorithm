package zuo.chapter9;

/**
 * @author keboom
 * @date 2021/7/16
 */
public class Div {

    /**
     * 计算两个正整数的除法
     *
     * @param x
     * @param y
     * @return
     */
    public int div(int x, int y) {
        int left_num = x;
        int result = 0;
        // 如果left_num是大于y的，那就说明还能够被y除
        while (left_num >= y) {
            int multi = 1;
            // multi相当于商，每次我们只去left_num一半来计算
            while (y * multi <= (left_num >> 1)) {
                multi = multi << 1;
            }
            result += multi;
            left_num -= y * multi;
        }
        return result;
    }
}
