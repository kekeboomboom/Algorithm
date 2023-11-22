package leetcode;

import java.time.temporal.Temporal;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/11/22
 */
public class LeetCode860 {

    /**
     * customer will pay 5 10 20, if pay 5,then directly get it in my charges.
     * if pay 10, then change to $5. if don't have 5,then return false
     * if pay 20, first we change to $10. if we don't have $10,then we change three $5.if we still not have.
     * then return false.
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarNum = 0;
        int tenDollarNum = 0;
        int twentyDollarNum = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveDollarNum++;
            } else if (bill == 10) {
                if (fiveDollarNum == 0) {
                    return false;
                }
                fiveDollarNum--;
                tenDollarNum++;
            } else {
                if (tenDollarNum == 0) {
                    if (fiveDollarNum < 3) {
                        return false;
                    } else {
                        fiveDollarNum -= 3;
                        twentyDollarNum++;
                    }
                } else {
                    if (fiveDollarNum == 0) {
                        return false;
                    } else {
                        tenDollarNum--;
                        fiveDollarNum--;
                        twentyDollarNum++;
                    }
                }
            }
        }
        return true;
    }
}
