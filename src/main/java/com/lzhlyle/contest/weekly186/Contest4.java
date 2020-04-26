package com.lzhlyle.contest.weekly186;

public class Contest4 {
    // wa
    // dp
    // 每隔 <= k 个
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][2]; // 0不包括i，1包括i
        dp[0][1] = nums[0];
        for (int i = k; i < n; i++) {
            dp[i][0] = dp[i - k][1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j - i <= k && j < n; j++) { // j 是 i 的下一个
                dp[j][1] = Math.max(dp[j][1], dp[i][1] + nums[j]);
                dp[j][0] = Math.max(dp[j][0], dp[i][1]);
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
