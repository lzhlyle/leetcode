package com.lzhlyle.leetcode.tomorrow.no546;

public class RemoveBoxes_DP {
    // dp
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        return dfs(boxes, new int[n][n][n], 0, n - 1, 0);
    }

    // dp[l][r][k]: 从 l 到 r，之后还有 k 个与 arr[r] 相同
    private int dfs(int[] arr, int[][][] dp, int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];
        while (l < r && arr[r] == arr[r - 1]) {
            r--;
            k++;
        }

        // 策略1：直接消 [r, end] 之后的
        int max = (k + 1) * (k + 1) + dfs(arr, dp, l, r - 1, 0);

        // 策略2：先消 (i, r)，再消 [r, end] 之后的
        for (int i = l; i < r; i++)
            if (arr[i] == arr[r])
                max = Math.max(max,
                        dfs(arr, dp, i + 1, r - 1, 0)) +
                        dfs(arr, dp, l, i, k + 1);
        return dp[l][r][k] = max;
    }
}
