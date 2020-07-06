package com.lzhlyle.leetcode.week.no139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_DP {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1]; // [0, i)
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int p = 0; p < i; p++) {
                dp[i] = dp[p] && set.contains(s.substring(p, i));
                if (dp[i]) break;
            }
        }
        return dp[n];
    }
}
