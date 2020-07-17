package com.lzhlyle.leetcode.week.lcci1713;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReSpaceLcci_DP_Set {
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1]; // before i
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) { // faster
                if (set.contains(sentence.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j]);
                else dp[i] = Math.min(dp[i], dp[j] + i - j);
                if (dp[i] == 0) break;
            }
        }
        return dp[n];
    }
}
