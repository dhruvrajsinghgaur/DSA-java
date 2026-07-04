package Patterns.intervals;

public class LC_416 {

    // Method 0.
    // TC: O(n * target).
    // SC: O(n).
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) totalSum += nums[i];
        if (totalSum % 2 != 0) return false;
        int target = totalSum/2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums){
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }
        return dp[target];
    }

    // Method 1. (it uses memoization to optimize recursion)
    // TC: O(n * target).
    // SC: O(n * target).
    public boolean canPartition1(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) totalSum += nums[i];
        if (totalSum % 2 != 0) return false;
        int target = totalSum/2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return solve(nums, target, 0, memo);
    }
    private boolean solve(int[] nums, int target, int i, Boolean[][] memo){
        if (target == 0) return true;
        if (i == nums.length || target < 0) return  false;

        if (memo[i][target] != null) return memo[i][target];

        boolean take = solve(nums, target - nums[i], i + 1, memo);
        boolean skip = solve(nums, target, i + 1, memo);

        return memo[i][target] = take || skip;
    }

    // Method 2.
    // TC: O(2^n). (gives TLE on leetCode)
    // SC: O(n).
    public boolean canPartition2(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) totalSum += nums[i];
        if (totalSum % 2 != 0) return false;
        return solve(nums, totalSum/2, 0);
    }
    private boolean solve(int[] nums, int target, int i){
        if (target == 0) return true;
        if (i == nums.length || target < 0) return  false;

        boolean take = solve(nums, target - nums[i], i + 1);
        boolean skip = solve(nums, target, i + 1);

        return take || skip;
    }
}