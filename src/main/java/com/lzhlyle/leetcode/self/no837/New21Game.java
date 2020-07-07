package com.lzhlyle.leetcode.self.no837;

public class New21Game {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        double sum = 0d;
        for (int i = K; i <= N && i < K + W; i++)
            sum += dp[i] = 1d;
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sum / W;
            sum += dp[i] - dp[i + W];
        }
        return dp[0];
    }
}
