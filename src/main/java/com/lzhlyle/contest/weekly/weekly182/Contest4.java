package com.lzhlyle.contest.weekly.weekly182;

import java.util.HashSet;
import java.util.Set;

public class Contest4 {
    // dp
    // 上一个位相同，则可选a到b，否则可选26-evil种
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if (s1.startsWith(evil) && s2.startsWith(evil)) return 0;
        Set<Character> set = new HashSet<>();
        for (char c : evil.toCharArray()) set.add(c);

        boolean prefix = true; // ""
        int[] dp = new int[n]; // 每个字符位置可选的情况数量
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            prefix = prefix && c1 == c2;
            if (prefix && set.contains(c1)) return 0;

            if (i == 0) {

            } else {

            }
        }

        int MOD = 1000000007;
//        return (int) (cnt % MOD);
        return -1;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
