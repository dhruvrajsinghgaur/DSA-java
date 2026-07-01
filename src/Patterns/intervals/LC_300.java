package Patterns.intervals;

import java.util.Arrays;

public class LC_300 {

    // Method 0.
    // TC: O(n logn).
    public int lenghtOfLIS(int[] nums){
        int[] tail = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(tail, 0, size, num);

            if (index < 0) index = -(index + 1);

            tail[index] = num;

            if (index == size) size++;
        }
        return size;
    }

    // Method 1.
    // TC: O(n^2).
    public int lengthOfLIS1(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int globalCounter = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            globalCounter = Math.max(globalCounter, dp[i]);
        }
        return globalCounter;
    }

    // Method 2. (gives TLE on leetCode)
    // TC: O(2^n).
    public int lengthOfLIS2(int[] nums) {
        int globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            globalMax = Math.max(globalMax, dfs(nums, i));
        }
        return globalMax;
    }

    private int dfs(int[] nums, int index){
        int best = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) best = Math.max(best, 1 + dfs(nums, i));
        }
        return best;
    }

    void main(){
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums1 = {0,1,0,3,2,3};
        int[] nums2 = {2,15,3,7,8,6,18};

        System.out.println(lengthOfLIS1(nums2));
    }
}
