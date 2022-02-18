package sort;

/**
 * @author keboom
 * @date 2022/2/18
 */
public class InsertionSort {

  // 插入排序
  public int[] insertSort(int[] nums) {
    int cur = 0;
    for (int i = 0; i < nums.length; i++) {
      cur = nums[i + 1];
      int preIndex = i;
      while (preIndex >= 0 && cur < nums[preIndex]) {
        nums[preIndex + 1] = nums[preIndex];
        preIndex--;
      }
      nums[preIndex + 1] = cur;
    }
    return nums;
  }
}
