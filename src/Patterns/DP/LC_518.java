package Patterns.DP;

import java.util.Arrays;

public class LC_518 {

    public int change(int amount, int[] coins){
        int[][] memo = new int[amount + 1][coins.length];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(amount,0, coins, memo);
    }
    private int solve(int amount, int index, int[] coins, int[][] memo){
        if (amount == 0) return 1;
        if (index == coins.length) return 0;
        if (amount < 0) return 0;

        if (memo[amount][index] != -1) return memo[amount][index];

        int take = solve(amount - coins[index], index, coins, memo);
        int dontTake = solve(amount, index + 1, coins, memo);

        memo[amount][index] = take + dontTake;
        return memo[amount][index];
    }

    void main(){
        int[] coins = {1, 2, 5};
        int amount = 5;

        System.out.println(change(amount, coins));
    }
}
