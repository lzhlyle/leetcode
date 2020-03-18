package com.lzhlyle.leetcode.recite.no403;

public class FrogJump_LC_DP_BottomUp {

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        int len = stones.length;
        boolean[][] dp = new boolean[len][len + 1]; // curr-stone, next-steps
        dp[0][1] = true;
        for (int to = 1; to < len; ++to) { // 枚举落脚点
            for (int from = 0; from < to; ++from) { // 枚举起跳点
                int far = stones[to] - stones[from]; // 距离
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
