package SwordPointToOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author keboom
 * @date 2021/7/23
 */
public class Offer40 {

//     第一种使用堆，这是TopK问题，我们要求的最小的k个数，所以要大顶堆
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, ((o1, o2) -> o2 - o1));
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() <= k || arr[i] < queue.peek()) {
                queue.offer(arr[i]);
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[queue.size()];
        int j = 0;
        for (Integer integer : queue) {
            res[j++] = integer;
        }
        return res;
    }




    public static void main(String[] args) {
        int k = 3;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        queue.add(2);
        queue.add(1);
        queue.add(4);
        queue.add(3);
        Object[] array = queue.toArray();
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(array[i].toString());
        }
        System.out.println("````````````````````````````");
        System.out.println(queue.peek());
        System.out.println("````````````````````````````");
        System.out.println(queue.poll());
        System.out.println("````````````````````````````");

        Object[] array2 = queue.toArray();
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(array2[i].toString());
        }
    }





    /*
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
    ****************************************************
     */


    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition2(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    //这是以high为中间值的
    public int partition2(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    // 这是以lo为中间值，我为了减少记忆负担，我就去记忆以high为中间值的吧
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }











}
