package com.lzhlyle.leetcode.recite.no887;

public class SuperEggDrop_Memorize {
    // tle

    private int[][] memo;

    public int superEggDrop(int K, int N) {
        memo = new int[K + 1][N + 1]; // 剩余 K 个鸡蛋，待测 N 层楼
        return drop(K, N);
    }

    private int drop(int K, int N) {
        if (K == 1 || N == 1 || N == 0) return memo[K][N] = N;
        if (memo[K][N] != 0) return memo[K][N];

        int min = N;
        // 每层都尝试
        for (int i = 1; i <= N; i++) {
            // 每次尝试都按最坏结果的计算
            int max = Math.max(drop(K - 1, i - 1), drop(K, N - i)) + 1;
            // 选至少的
            min = Math.min(min, max);
        }
        return memo[K][N] = min;
    }
}
