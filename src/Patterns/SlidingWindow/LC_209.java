package Patterns.SlidingWindow;

public class LC_209 {
    // Method 1.
    // TC: O(N).
    // this method is optimal for this question.
    public int minSubArrayLen(int k, int[] nums){
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while(right < nums.length){
            sum += nums[right];
            while (sum >= k){
                int length = right - left + 1;
                minLength = Math.min(minLength, length);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Method 2.
    // TC: O(N^2).
    // this method gives TLE on leetCode.
    public int minSubArrayLen1(int k, int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i -1] + nums[i];
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int subArraySum;
                if (i == 0) subArraySum = prefixSum[j];
                else subArraySum = prefixSum[j] - prefixSum[i - 1];
                if (subArraySum >= k){
                    int length = j - i + 1;
                    if (minLength > length) minLength = length;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
