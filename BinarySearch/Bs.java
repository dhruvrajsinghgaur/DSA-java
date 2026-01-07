public class Bs {
    public static void main (String[] args) {
        int nums[] = {99,99,56,55,53,45,34,23,12,1};
        int target = 53;
        System.out.println(binarysearch(nums, target));
    }
    // OrderAgnostic Binary Search
    // This method performs a binary search on a sorted array that can be either in ascending or descending order.

    static int binarysearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1; // Array is empty or null
        }
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end]; // Check order once

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            }

            if (isAsc) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1; // Target not found
    }
}
