package zuo.chapter3;

import java.util.List;

/**
 * @author keboom
 * @date 2021/5/21
 */
public class MaxHappy {

    public class Employee {
        public int happy;
        List<Employee> subordinates;
    }

    public class ReturnData {
        public int yesHeadMax;
        public int noHeadMax;

        public ReturnData(int yesHeadMax, int noHeadMax) {
            this.yesHeadMax = yesHeadMax;
            this.noHeadMax = noHeadMax;
        }
    }

    public ReturnData process(Employee X) {
        int yesX = X.happy;
        int noX = 0;
        if (X.subordinates.isEmpty()) {
            return new ReturnData(yesX, noX);
        } else {
            for (Employee next : X.subordinates) {
                ReturnData subTreeInfo = process(next);
                yesX += subTreeInfo.noHeadMax;
                noX += Math.max(subTreeInfo.yesHeadMax, subTreeInfo.noHeadMax);
            }
        }
        return new ReturnData(yesX, noX);
    }

    public int getMaxHappy(Employee boss) {
        ReturnData allTreeInfo = process(boss);
        return Math.max(allTreeInfo.noHeadMax, allTreeInfo.yesHeadMax);
    }
}
