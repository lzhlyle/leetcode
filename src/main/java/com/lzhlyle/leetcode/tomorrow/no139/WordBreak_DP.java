package com.lzhlyle.leetcode.tomorrow.no139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_DP {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1]; // +""
        dp[0] = true;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i && !dp[i]; j++)
                dp[i] = dp[j] && set.contains(s.substring(j, i));
        return dp[n];
    }
}
