package leetcode;

import java.util.Arrays;

public class LeetCode453 {

  public int minMoves(int[] nums) {
    if (nums == null){
      return -1;
    }
    Arrays.sort(nums);
    int operation = 0;
    int len = nums.length;
    while (nums[0] != nums[len -1]){
      if (nums[len - 1] >= nums[len -2]){
        for (int i = 0; i < len - 1; i++) {
          nums[i] = nums[i] + 1;
        }
      }
      Arrays.sort(nums);
      operation++;
    }
    return operation;
  }

}
