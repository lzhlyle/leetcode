package com.lzhlyle.leetcode.tomorrow.lcci1713;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReSpaceLcci_DP_Set {
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1]; // before i
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(sentence.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j]);
                else dp[i] = Math.min(dp[i], dp[j] + i - j);
            }
        }
        return dp[n];
    }
}
