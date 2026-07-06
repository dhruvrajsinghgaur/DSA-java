package Patterns.DP;

public class LC_1143 {

    // Method 0. (recursion + memoization)
    // A pure recursion solution without memoization will have TC of O(2^(m*n))
    // TC: O(m * n).
    // SC: O(m * n).
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return helper(text1, text2, 0, 0, memo);
    }
    private int helper(String text1, String text2, int i, int j, Integer[][] memo){
        if (i >= text1.length() || j >= text2.length()) return 0;
        if (memo[i][j] != null) return memo[i][j];
        if (text1.charAt(i) == text2.charAt(j)){
            return memo[i][j] = 1 + helper(text1, text2, i + 1, j + 1, memo);
        }
        else {
            int choice1 = helper(text1, text2, i + 1, j, memo);
            int choice2 = helper(text1, text2, i, j + 1, memo);
            return  memo[i][j] =  Math.max(choice1, choice2);
        }
    }


}
