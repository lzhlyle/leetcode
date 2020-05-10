package com.lzhlyle.contest.weekly.weekly188;

public class Contest4 {
    private static int MOD = (int) (1e9 + 7);

    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i] = pizza[i].toCharArray();
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] == 'A') {
                for (int r = 0; r < m; r++) dp[r][n - 1] = 1;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[m - 1][j] == 'A') {
                for (int c = 0; c < m; c++) dp[m - 1][c] = 1;
                break;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j + 1];
                // ...k?
            }
        }
        return dp[0][0];
    }

    private int apple(char[][] matrix, int il, int ir, int j) {
        int cnt = 0;
        for (int i = il; i <= ir; i++) {
            if (matrix[i][j] == 'A') cnt++;
        }
        return cnt;
    }

    private int apply(char[] row, int jl, int jr) {
        int cnt = 0;
        for (int j = jl; j <= jr; j++) {
            if (row[j] == 'A') cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
