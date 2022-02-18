package sort;

/**
 * @author keboom
 * @date 2022/2/18
 */
public class ShellSort {

  //希尔排序 --- 插入排序的增强版
  public int[] shellSort(int[] nums) {
    int len = nums.length;
    int temp,gap = len/2;
    while (gap > 0) {
      for (int i = gap; i < len; i++) {
        temp = nums[i];
        int preIndex = i - gap;
        while (preIndex >= 0 && temp < nums[preIndex]) {
          nums[preIndex + gap] = nums[preIndex];
          preIndex -= gap;
        }
        nums[preIndex + gap] = temp;
      }
      gap /= 2;
    }
    return nums;
  }

}
