package Patterns.intervals;

import java.util.Arrays;

public class LC_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = solve(coins, amount, dp);
        // System.out.println(Arrays.toString(dp));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int solve(int[] coins, int amount, int[] dp){
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        if (dp[amount] != -1) return dp[amount];

        int best = Integer.MAX_VALUE;
        for (int coin : coins){
            int res = solve(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE) best = Math.min(best, 1 + res);
        }
        dp[amount] = best;
        return best;
    }

    void main(){
        int[] coins = {1, 2, 5};
        int ans = coinChange(coins, 11);
        System.out.println(ans);
    }
}
