package com.lzhlyle.leetcode.recite.no455;

import java.util.Arrays;

public class AssignCookies_2 {
    public int findContentChildren(int[] g, int[] s) {
        // base condition
        if (g.length < 1 || s.length < 1) return 0;

        // greedy
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int childIndex = 0, cookieIndex = 0;
        while (childIndex < g.length && cookieIndex < s.length) {
            if (g[childIndex] <= s[cookieIndex]) {
                count++;
                childIndex++;
            }
            cookieIndex++;
        }
        return count;
    }
}
