package leetcode;

/**
 * {@code @author:} keboom
 * {@code @date:} 2023/8/29
 */
public class LeetCode1004 {

    /**
     * 我先找到第一个为1的位置，然后不停的往下找，如果是1则接着往下，如果是0，则判断k是否大于0，如果大于零，则k--，然后继续往下找
     * 直到把k消耗到为0，然后计算当前窗口长度。然后窗口长度清零，接着找下一个1的位置
     * 边界条件：如果k大于零，但是此时已经到了数组末尾，则尝试从第一个1的位置向『左』消耗k
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int index=0;
        int maxLen = 0;
        int curLen=0;
        int tmpK = k;
        while (index < nums.length) {
            if (nums[index] == 0 && curLen == 0) {
                index++;
            } else if (nums[index] == 1) {
                curLen++;
                index++;
            } else if (nums[index] == 0 && curLen != 0 && tmpK > 0) {
                tmpK--;
                curLen++;
                index++;
            } else if (nums[index] == 0 && curLen != 0 && tmpK == 0) {
                maxLen = Math.max(maxLen, curLen);
                curLen = 0;
                index++;
                tmpK = k;
            }
        }

        if (tmpK > 0) {
            index = index - curLen - 1;
            while (index >= 0 && tmpK > 0) {
                if (nums[index] == 0) {
                    tmpK--;
                    curLen++;
                    index--;
                } else {
                    curLen++;
                    index--;
                }
            }
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    /**
     * 第一种方法有缺陷，会导致漏掉一些情况。比如：{1,0,0,1,0,0,   1,0,    1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1   ,0,0,1,0,1   ,0,0,1,0,0,1,1};
     * 这个例子的最长长度为32，应该截取 1,0,    1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1   ,0,0,1,0,1  这一段。但是第一中算法会漏掉这种情况
     * 所以我这次找到要遍历所有情况。我找到以『1』为开头的：比如说数组第一位是1，比如说第i位是1但前一位是0
     * 找到以『1』开头的，然后向后找，遇到0，就消耗k，直到k消耗光，得到当前长度。然后不断以这种『1』的位置得到一个长度。最终拿到所有长度中，最大的。
     * 边界情况：遍历到了数组结尾，但是k还没有消耗完，那么就需要找到窗口起始点，向后消耗k。这个在第一种算法中也做过处理。
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes2(int[] nums, int k) {
        // 如果nums中全是0，那么maxLen最小是k的长度
        int index = 0, curLen = 0, maxLen = k, tmpK = k;
        // 第一个while循环就去找以『1』开头的
        while (index < nums.length) {
            if ((index == 0 && nums[index] == 1) || (index > 0 && nums[index] == 1 && nums[index - 1] == 0)) {
                // 如果找到以『1』开头的，那么我们计算以此开头的一个窗口的长度
                curLen++;
                int tmpIndex = index + 1;
                while (tmpIndex < nums.length && tmpK >= 0) {
                    if (nums[tmpIndex] == 0 && tmpK>0) {
                        curLen++;
                        tmpK--;
                        tmpIndex++;
                    } else if (nums[tmpIndex] == 0 && tmpK == 0) {
                        break;
                    } else {
                        curLen++;
                        tmpIndex++;
                    }
                }
                // 如果遍历到最后，k还没有消耗完，那么就向后
                if (tmpK > 0) {
                    tmpIndex = index - 1;
                    while (tmpIndex >= 0 && tmpK >= 0) {
                        if (nums[tmpIndex] == 0 && tmpK>0) {
                            tmpK--;
                            curLen++;
                            tmpIndex--;
                        } else if (nums[tmpIndex] == 0 && tmpK == 0) {
                            break;
                        } else {
                            curLen++;
                            tmpIndex--;
                        }
                    }
                }
                maxLen = Math.max(maxLen, curLen);
                curLen=0;
                tmpK = k;
            }
            index++;
        }
        return maxLen;
    }

    /**
     * 上面的方法2虽然能过，但是时间复杂度太高。因为我有很多的重复遍历。看其他人的题解，他们是o(n)的时间复杂度
     * 题解较好的是一个用滑动窗口解法的，他把题目换了一种角度理解，原本题目是说可以将k个0替换成1. 那么他把题意转化成允许窗口内最多k个0
     * 这样right指针不停向右，如果right指针遍历到了0，那么就需要left指针向右移动，直到窗口内0最多为k个
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes3(int[] nums, int k) {
        int left=0,right=0,maxLen=0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (k == 0) {
                    if (nums[left] == 1) {
                        while (left < right && nums[left] == 1) {
                            left++;
                        }
                    }
                    left++;
                } else {
                    k--;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        LeetCode1004 leetCode1004 = new LeetCode1004();
//        int[] nums = {1,0,0,1,0,0,   1,0,    1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1   ,0,0,1,0,1   ,0,0,1,0,0,1,1};
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int i = leetCode1004.longestOnes3(nums, 3);
        System.out.println(i);
    }
}
