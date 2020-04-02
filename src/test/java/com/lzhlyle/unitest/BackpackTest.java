package com.lzhlyle.unitest;

import org.junit.Test;

import java.util.Random;

public class BackpackTest {
    // weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false，第二维度：下一次的决策，依赖于上一次已经放到了多少
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) states[0][weight[0]] = true;

        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) { // 不把第i个物品放入背包
                if (states[i - 1][j]) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { //把第i个物品放入背包
                if (states[i - 1][j]) states[i][j + weight[i]] = true;
            }
        }

        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i]) return i;
        }
        return 0;
    }

    public static int knapsackWithValue(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        if (weight[0] <= w) states[0][weight[0]] = value[0];

        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }

        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }

    @Test
    public void knapsackTest() {
        for (int i = 0; i < 100; i++) {
            int n = 10, w = 100;
            int[] weight = new Random().ints(n, 1, 100).toArray();
            int res = this.knapsack(weight, n, w);
            System.out.println(res);
        }
    }
}
