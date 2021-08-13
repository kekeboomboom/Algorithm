package sort;

/**
 * @author keboom
 * @date 2021/8/13
 */
public class BinarySearch {

    public static int binSearch(int[] arr, int left, int right, int key) {
        if (key < arr[left] || key > arr[right] || left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (arr[middle] > key) {
            return binSearch(arr, left, middle - 1, key);
        } else if (arr[middle] < key) {
            return binSearch(arr, middle + 1, right, key);
        } else {
            return middle;
        }
    }

    public static int binSearch2(int[] arr, int key) {
        if (arr.length <= 0 || key < arr[0] || key > arr[arr.length - 1]) {
            return -1;
        }
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] > key) {
                high = mid-1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
