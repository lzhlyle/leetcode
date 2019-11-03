package com.lzhlyle.leetcode.recite.no455;

import java.util.Arrays;

public class AssignCookies_3 {
    public int findContentChildren(int[] g, int[] s) {
        // base condition
        if (g.length < 1 || s.length < 1) return 0;

        // greedy
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for (int cookie = 0; count < g.length && cookie < s.length; cookie++) {
            if (g[count] <= s[cookie]) count++;
        }
        return count;
    }
}
