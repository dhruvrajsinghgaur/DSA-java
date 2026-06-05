package Patterns.KanadeAlgo;

public class LC_121 {
    public int maxProfit(int[] prices){
        int buyPoint = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            buyPoint = Math.min(prices[i], buyPoint);
            maxProfit = Math.max(maxProfit, buyPoint - prices[i]);
        }
        return maxProfit;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        p[0] = 1;
        for(int i = 1; i < n; i++){
            p[i] = p[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            p[i] = p[i] * suffix;
            suffix = suffix * nums[i];
        }
        return p;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;

        int[] p = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i++){
            p[i] = prefix[i] * suffix[i];
        }

        return p;
    }
}
