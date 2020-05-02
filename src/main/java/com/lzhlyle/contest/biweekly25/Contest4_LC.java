package com.lzhlyle.contest.biweekly25;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contest4_LC {
    public int numberWays(List<List<Integer>> hats) {
        int mod = (int) (1e9 + 7);
        int n = hats.size();
        long[] dp = new long[1 << n];
        Set[] set = new Set[41];
        for (int i = 1; i < 41; i++) {
            set[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < hats.get(i).size(); j++) {
                set[hats.get(i).get(j)].add(i);
            }
        }
        dp[0] = 1;
        for (int i = 1; i <= 40; i++) {
            long[] cur = dp.clone();
            for (int j = 1; j < dp.length; j++) {
                for (int k = 0; k < n; k++) {
                    int tmp = 1 << k;
                    if ((j & tmp) > 0 && set[i].contains(k)) {
                        cur[j] = (cur[j] + dp[j ^ tmp]) % mod;
                    }
                }
            }
            dp = cur;
        }
        return (int) dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Contest4_LC contest = new Contest4_LC();
        {

        }
    }
}
