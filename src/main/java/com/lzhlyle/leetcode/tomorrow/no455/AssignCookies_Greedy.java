package com.lzhlyle.leetcode.tomorrow.no455;

import java.util.Arrays;

public class AssignCookies_Greedy {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookie = 0, child = 0;
        while (cookie < s.length && child < g.length) {
            if (s[cookie++] >= g[child]) child++;
        }
        return child;
    }
}
