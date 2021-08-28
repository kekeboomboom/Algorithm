package other.exam.zoom;

/**
 * @author keboom
 * @date 2021/8/28
 */
public class Solution1 {

    public int find132Pattern (int[] nums) {
        int len = nums.length;
        int count = 0;
        // 第一个数
        for (int i = 0; i < len-2; i++) {
            // 第二个数
            for (int j = i+1; j < len-1; j++) {
                // 第三个数
                for (int k = j+1; k < len; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 0};
        int res = new Solution1().find132Pattern(nums);
        System.out.println(res);
    }
}
