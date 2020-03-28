package com.lzhlyle.leetcode.week.no403;

public class FrogJump_LC_DP_BottomUp {
    // stone, next-step
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        int len = stones.length;
        boolean[][] dp = new boolean[len][len + 1];
        dp[0][1] = true;
        for (int to = 0; to < len; to++) {
            for (int from = 0; from < to; from++) {
                int far = stones[to] - stones[from];
                if (far > len || !dp[from][far]) continue;
                if (to == len - 1) return true;
                dp[to][far] = true;
                if (far - 1 >= 0) dp[to][far - 1] = true;
                if (far + 1 <= len) dp[to][far + 1] = true;
            }
        }
        return false;
    }
}
