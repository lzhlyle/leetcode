package com.lzhlyle.contest.biweekly.biweekly29;

public class Contest3 {
    // dp
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[][] dp = new int[n][2]; // 以 i 结尾，0:无零, 1:有零，不包括 0 的全长
        if (nums[0] == 1) dp[0][0] = 1;

        int max = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                dp[i][1] = dp[i - 1][0];
            } else {
                // nums[i] == 1
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        if (max == n) return max - 1;
        return max;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
