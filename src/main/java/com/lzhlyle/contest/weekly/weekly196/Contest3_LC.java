package com.lzhlyle.contest.weekly.weekly196;

public class Contest3_LC {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 前缀和
        int[][] pre = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i][j] = mat[i][j] + (j > 0 ? pre[i][j - 1] : 0);
            }
        }

        int res = 0;
        // 枚举左右列
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                int rowCnt = 0; // 全 1 的行数

                // 遍历行
                for (int i = 0; i < m; i++) {
                    // 统计 [l, r] 中 1 的个数： start...[l...r]
                    int oneCnt = pre[i][r];
                    if (l > 0) oneCnt -= pre[i][l - 1];

                    if (oneCnt == (r - l + 1)) rowCnt++; // 连续
                    else { // 不连续
                        // 累计上面的全 1 行组成的矩形
                        // 1 + 2 + ... + rowCnt
                        res += rowCnt * (rowCnt + 1) / 2;
                        rowCnt = 0; // 清零
                    }
                }

                // 补充最后一次 rowCnt 的累计
                if (rowCnt > 0) res += rowCnt * (rowCnt + 1) / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3_LC contest = new Contest3_LC();
        {

        }
    }
}
