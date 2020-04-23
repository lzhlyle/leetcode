package com.lzhlyle.leetcode.week.no76;

public class MinimumWindowSubstring_TwoPoints {
    // two points
    // O(n+m)
    public String minWindow(String s, String t) {
        char[] sarr = s.toCharArray(), tarr = t.toCharArray();
        int slen = sarr.length, tlen = tarr.length;

        int[] need = new int[256], hire = new int[256];
        for (char c : tarr) need[c] = ++hire[c];
        int expected = tlen;

        int l = 0, r = l, len = 0, minL = l, minLen = slen + 1; // minLen: unreachable value
        while (l < slen - tlen + 1 && r < slen) {
            if (len < r - l + 1) {
                int hiring = sarr[r];
                if (need[hiring] > 0 && hire[hiring] > 0) expected--;
                hire[hiring]--;
            } else {
                int leaving = sarr[l - 1];
                hire[leaving]++;
                if (need[leaving] > 0 && hire[leaving] > 0) expected++;
            }

            len = r - l + 1;
            if (expected > 0) r++;
            else {
                if (len < minLen) {
                    minLen = len;
                    minL = l;
                }
                l++;
            }
        }
        return minLen == slen + 1 ? "" : new String(sarr, minL, minLen);
    }
}
