package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/10/31
 */
public class LeetCode376 {

    /**
     * 这个方式是求连续的，应该叫子数组
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int tmpLen =1;
        int maxLen = 0;
        int preDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            if (preDiff == 0) {
                preDiff = nums[i] - nums[i - 1];
                if (preDiff != 0) {
                    tmpLen++;
                }
                continue;
            }
            if (preDiff > 0) {
                preDiff = nums[i] - nums[i - 1];
                if (preDiff >= 0) {
                    maxLen = Math.max(maxLen, tmpLen);
                    tmpLen = 1;
                } else {
                    tmpLen++;
                }
            } else {
                preDiff = nums[i] - nums[i - 1];
                if (preDiff <= 0) {
                    maxLen = Math.max(maxLen, tmpLen);
                    tmpLen = 1;
                } else {
                    tmpLen++;
                }
            }
        }
        return Math.max(maxLen, tmpLen);
    }


    /**
     * this is subsequence
     * first, calculate -1 or 1
     * second, find most length wiggle sequence. my strategy is: if first is 1, then find next -1, then find next 1
     * then maybe find longest sequence
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        if (nums.length == 2) {
            if (nums[0] != nums[1]) {
                return nums.length;
            } else {
                return 1;
            }
        }
        int[] diffArr = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            diffArr[i-1] = nums[i] - nums[i - 1];
        }
        int resLen = 1;
        int index = 0;
        int preDiff = 0;
        while (index < diffArr.length) {
            if (diffArr[index] == 0) {
                index++;
            } else {
                preDiff = diffArr[index];
                index++;
                resLen++;
                break;
            }
        }
        for (int i = index; i < diffArr.length; i++) {
            if (diffArr[i] * preDiff < 0) {
                preDiff = diffArr[i];
                resLen++;
            }
        }
        return resLen;
    }
    public static void main(String[] args) {
        LeetCode376 leetCode376 = new LeetCode376();
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        int i = leetCode376.wiggleMaxLength2(nums);
        System.out.println(i);
    }
}
