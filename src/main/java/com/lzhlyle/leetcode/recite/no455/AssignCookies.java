package com.lzhlyle.leetcode.recite.no455;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // base condition
        if (g.length < 1 || s.length < 1) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < g.length; i++) {
            for (int j = i; j < s.length; j++) {
                if (!used.contains(j) && s[j] >= g[i]) {
                    count++;
                    used.add(j);
                    break;
                }
            }
        }
        return count;
    }
}
