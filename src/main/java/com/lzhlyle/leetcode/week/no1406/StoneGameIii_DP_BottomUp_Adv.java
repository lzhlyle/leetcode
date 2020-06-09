package com.lzhlyle.leetcode.week.no1406;

public class StoneGameIii_DP_BottomUp_Adv {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int dp1 = stoneValue[len - 1], dp2 = 0, dp3 = 0, sum = dp1;
        for (int i = len - 2; i >= 0; i--) {
            sum += stoneValue[i];
            int dp0 = sum - Math.min(dp1, Math.min(dp2, dp3));
            dp3 = dp2;
            dp2 = dp1;
            dp1 = dp0;
        }
        int a = dp1, b = sum - a;
        return a == b ? "Tie" : (a > b ? "Alice" : "Bob");
    }
}
