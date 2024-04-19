package leetcode;

import sun.util.resources.cldr.xh.CurrencyNames_xh;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/11/7
 */
public class LeetCode45 {

    /**
     * 这题让找最少几步能到终点
     * 首先暴力破解，就是遍历所有可能性
     * 第二个，我们只能尝试贪心可不可以。
     * 维护一个当前坐标，当前坐标要跳到下一个节点，而下一个节点能跳到的最远的位置就是它自己的index加上j
     * 我们每次寻找这下一个节点时，都尽力找能跳的最远的那个。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int curIndex = 0;
        int minJumps = 1;
        while (curIndex < nums.length) {
            int farthest=0;
            int nextIndex=curIndex;
            for (int i = curIndex; i <= curIndex + nums[curIndex]; i++) {
                if ((i + nums[i]) > farthest) {
                    farthest = i + nums[i];
                    nextIndex = i;
                    if (farthest >= nums.length - 1) {
                        if (i == curIndex) {
                            return minJumps;
                        } else {
                            return minJumps + 1;
                        }
                    }
                }
            }
            curIndex = nextIndex;
            minJumps++;
        }
        return minJumps;
    }

    /**
     * 站在当前位置，寻找下一步能跳最远的位置
     * 再一次写，又会有另一种写法，哈哈
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int curPos = 0;
        int arriveFarther = curPos + nums[curPos];
        int step = 0;
        while (curPos < nums.length-1) {
            int nextStep = curPos + 1;
            for (int i = curPos+1; i <= arriveFarther; i++) {
                if (i == nums.length - 1) {
                    return ++step;
                }
                if ((i + nums[i]) >= (nextStep + nums[nextStep])) {
                    nextStep = i;
                }
            }
            curPos = nextStep;
            arriveFarther = nextStep + nums[nextStep];
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        LeetCode45 leetCode45 = new LeetCode45();
        int[] nums = {2, 3, 1, 1, 4};
        int jump = leetCode45.jump(nums);

    }
}
