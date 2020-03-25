package com.lzhlyle.leetcode.recite.no76;

public class MinimumWindowSubstring_TwoPoints {
    // two points
    // O(n+m)
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE, slen = s.length(), tlen = t.length();
        if (slen < tlen) return "";

        char[] sarr = s.toCharArray(), tarr = t.toCharArray();
        int[] need = new int[256], hire = new int[256];
        int expected = tarr.length;
        for (char c : tarr) need[c] = ++hire[c]; // O(n)

        int l = 0, r = l, len = 0, minL = 0, minLen = 0;
        while (l < slen - tlen + 1 && r < slen) { // O(n+m)
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
            if (expected <= 0) {
                if (len < min) {
                    min = len;
                    minL = l;
                    minLen = len;
                }
                l++;
            } else r++;
        }
        return min == Integer.MAX_VALUE ? "" : new String(sarr, minL, minLen);
    }

    public static void main(String[] args) {
        String S = "aaaaaaaaaaaabbbbbcdd", T = "abcdd";
        String res = new MinimumWindowSubstring_TwoPoints().minWindow(S, T);
        System.out.println(res);
    }
}
