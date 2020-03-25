package com.lzhlyle.leetcode.self.no76;

public class MinimumWindowSubstring_TwoPoints {
    // two points
    // O(n+m)
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int slen = s.length(), tlen = t.length();
        char[] sarr = s.toCharArray(), tarr = t.toCharArray();

        int[] need = new int[256], hire = new int[256];
        for (char c : tarr) need[c] = ++hire[c];
        int expected = tarr.length;

        int l = 0, r = l, len = 0, minL = l, minLen = len;
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
                if (len < min) {
                    min = len;
                    minL = l;
                    minLen = len;
                }
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : new String(sarr, minL, minLen);
    }

    public static void main(String[] args) {
        String S = "aaaaaaaaaaaabbbbbcdd", T = "abcdd";
        String res = new MinimumWindowSubstring_TwoPoints().minWindow(S, T);
        System.out.println(res);
    }
}
