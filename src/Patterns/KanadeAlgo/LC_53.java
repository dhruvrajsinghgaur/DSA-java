package Patterns.KanadeAlgo;

public class LC_53 {
    public int maxSubArray(int[] nums){
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    void main(){
        int[] arr = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(maxSubArray(arr));

        System.out.println();
    }
}
