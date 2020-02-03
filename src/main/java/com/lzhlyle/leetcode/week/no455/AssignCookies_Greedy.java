package com.lzhlyle.leetcode.week.no455;

import java.util.Arrays;

public class AssignCookies_Greedy {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookie = 0, child = 0, gl = g.length, sl = s.length;
        while (cookie < sl && child < gl) if (s[cookie++] >= g[child]) child++;
        return child;
    }
}
