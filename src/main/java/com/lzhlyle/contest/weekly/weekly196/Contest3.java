package com.lzhlyle.contest.weekly.weekly196;

public class Contest3 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
//        // cont[i][j][0/1] 表示 mat[i][j] ：0向上（包括自己）有 b 个连续的，1向左（包括自己）有 c 个的连续
//        int[][][] cont = new int[m][n][2];
//        // 初始化
//        cont[0][0][0] = cont[0][0][1] = mat[0][0];
//        // 首行
//        for (int j = 1; j < n; j++) {
//            if (mat[0][j] == 1) {
//                cont[0][j][0] = 1;
//                cont[0][j][1] = cont[0][j - 1][1] + 1;
//            }
//        }
//        // 首列
//        for (int i = 1; i < m; i++) {
//            if (mat[i][0] == 1) {
//                cont[i][0][0] = cont[i - 1][0][0] + 1;
//                cont[i][0][1] = 1;
//            }
//        }
//        // 填充
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (mat[i][j] == 1) {
//                    cont[i][j][0] = cont[i - 1][j][0] + 1;
//                    cont[i][j][1] = cont[i][j - 1][1] + 1;
//                }
//            }
//        }

//        print(cont);
        int res = 0;
        int[][] dp = new int[m][n]; // 只记对角线的

        // 初始化
        dp[0][0] = mat[0][0];
        for (int i = 1; i < m; i++)
            if (mat[i][0] == 1)
                res += dp[i][0] = 1 + dp[i - 1][0];
        for (int j = 1; j < n; j++)
            if (mat[0][j] == 1)
                res += dp[0][j] = 1 + dp[0][j - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 1) {
                    res += dp[i][j] = 1 + dp[i - 1][j - 1];

//                    int b = i > 0 ? cont[i - 1][j][0] : 0;
//                    int c = j > 0 ? cont[i][j - 1][1] : 0;
//                    int dp0 = 0;
//                    if (i > 0 && j > 0) dp0 = dp[i - 1][j - 1];
//                    dp[i][j] = b + c + dp0 + 1;
//                    res += dp[i][j];
                }
            }
        }
        return res;
    }

    private int calc(int b, int c) {
        int b1 = b - 1, c1 = c - 1;
        return b1 * b1 * c1 * c1 * c / 2;
    }

    private void print(int[][][] cont) {
        for (int i = 0; i < cont.length; i++) {
            for (int j = 0; j < cont[0].length; j++) {
                System.out.println("i:" + i + ", j:" + j + "==up:" + cont[i][j][0] + ", left:" + cont[i][j][1]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
