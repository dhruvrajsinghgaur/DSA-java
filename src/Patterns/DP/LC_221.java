package Patterns.DP;

import java.util.Arrays;

public class LC_221 {

    // Method 0. (tabulation)
    // TC: O(n * m).
    // SC: O(n * m).
    public int maximalSquare(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    // Method 1. (memoization)
    // TC: O(n * m).
    // SC: O(n * m). (O(n * m) + O(n + m))
    public int maximalSquare1(char[][] matrix){
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        int globalMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int max = solve(i, j, matrix, memo);
                globalMax = Math.max(globalMax, max);
            }
        }
        return globalMax * globalMax;
    }
    private int solve(int i, int j, char[][] matrix, int[][] memo){
        if (i == matrix.length || j == matrix[i].length) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (matrix[i][j] == '1'){
            int right = solve(i, j + 1, matrix, memo);
            int down = solve(i + 1, j, matrix, memo);
            int diagonal = solve(i + 1, j + 1, matrix, memo);
            memo[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
            return memo[i][j];
        }
        memo[i][j] = 0;
        return memo[i][j];
    }

    // Method 2.
    // TC: O(n * m * k^2) if checkNewOne() is used and if isAllOne() used then TC will become O(n * m * k^3).
    // SC: O(1).
    public int maximalSquare2(char[][] matrix) {
        int globalMaxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') continue;
                int maxArea = 0;
                int di = i;
                int dj = j;
                while(di < matrix.length && dj < matrix[i].length && matrix[di][dj] == '1' && checkNewOne(i, j, di, dj, matrix)){
                    maxArea++;
                    di++;
                    dj++;
                }
                globalMaxArea = Math.max(globalMaxArea, maxArea*maxArea);
            }
        }
        return globalMaxArea;
    }
    private boolean isAllOne(int si, int sj, int ei, int ej, char[][] matrix){
        for (int i = si; i <= ei; i++){
            for (int j = sj; j <= ej; j++) {
                if (matrix[i][j] != '1') return false;
            }
        }
        return true;
    }

    private boolean checkNewOne(int si, int sj, int ei, int ej, char[][] matrix){
        for (int i = si; i < ei; i++){
            if (matrix[i][ej] == '0') return false;
        }
        for (int j = sj; j < ej; j++) {
            if (matrix[ei][j] == '0') return false;
        }
        return true;
    }

    void main(){

        // test cases.
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        char[][] matrix1 = {
                {0, 1},
                {1, 0}
        };

        char[][] matrix2 = {
                {'0'}
        };

        char[][] matrix3 = {};

        System.out.println(maximalSquare(matrix));
    }
}
