public class Ceiling {
    public static void main(String[] args) {
          char nums[] = {1,2,4,5,8,9,34,56,55};
        int target = 54;
        System.out.println(binarysearch(nums, target));
    }
     static int binarysearch(char[] arr, int target) {
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
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return arr[start];  // Return the ceiling value
    }
} 


class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        if (arr == null || arr.length == 0) {
            return ' '; // empty input case
        }
        
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                start = mid + 1; // move right
            } else {
                end = mid - 1; // move left
            }
        }
        if (start == arr.length) return arr[0];
        return arr[start];
    }
}
