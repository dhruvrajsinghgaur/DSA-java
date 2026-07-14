package Patterns.DP;

import java.util.Arrays;

public class LC_72 {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) Arrays.fill(row, -1);
        return solve(word1, word2, 0, 0, memo);
    }
    private int solve(String word1, String word2, int i, int j, int[][] memo){

        if (i == word1.length()) return word2.length() - j;

        if (j == word2.length()) return word1.length() - i;

        if (memo[i][j] != -1) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)){
            memo[i][j] =  solve(word1, word2, i + 1, j + 1, memo);
            return memo[i][j];
        }

        int insert = 1 + solve(word1, word2, i, j + 1, memo);
        int delete = 1 + solve(word1, word2, i + 1, j, memo);
        int replace = 1 + solve(word1, word2, i + 1, j + 1, memo);

        memo[i][j] = Math.min(insert, Math.min(delete, replace));

        return memo[i][j];
    }
}