package com.lzhlyle.contest.biweekly22;

public class Contest4_LC_DP {
    // 不相邻、子数列、最大和
    // wrong：不相邻、取 len / 3 个

    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        return Math.max(select(slices, 0, len - 1), select(slices, 1, len));
    }

    private int select(int[] arr, int l, int r) {
        int len = r - l + 1, cnt = arr.length / 3;
        int[][][] dp = new int[len][2][cnt + 1]; // 0:non, 1:select
        dp[0][1][1] = arr[l];
        dp[1][1][1] = arr[l + 1];
        int max = Math.max(dp[0][1][1], dp[1][1][1]);
        for (int i = 2; i < len; i++) {
            for (int curr = 1; curr <= cnt; curr++) {
                dp[i][0][curr] = Math.max(dp[i - 1][0][curr], dp[i - 1][1][curr]);
                dp[i][1][curr] = dp[i - 1][0][curr - 1] + arr[i];
                max = Math.max(max, Math.max(dp[i][0][curr], dp[i][1][curr]));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Contest4_LC_DP contest = new Contest4_LC_DP();
        {
            int[] arr = {8, 9, 8, 6, 1, 1};
            int res = contest.maxSizeSlices(arr);
            System.out.println(res);
        }
    }
}
