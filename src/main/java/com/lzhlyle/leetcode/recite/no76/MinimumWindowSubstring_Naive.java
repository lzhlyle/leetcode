package com.lzhlyle.leetcode.recite.no76;

public class MinimumWindowSubstring_Naive {
    // naive
    // O((m-n)*(m-n)*m)
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        String res = s;
        for (int l = 0, len = s.length(), tlen = t.length(); l < len - tlen + 1; l++) {
            for (int r = l + tlen - 1; r < len; r++) {
                String sub = s.substring(l, r + 1);
                char[] freq = new char[256];
                for (char c : sub.toCharArray()) freq[c]++;
                boolean match = true;
                for (char c : t.toCharArray()) {
                    if (freq[c]-- == 0) {
                        match = false;
                        break;
                    }
                }
                if (match && r - l + 1 < min) {
                    min = r - l + 1;
                    res = sub;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : res;
    }

    public static void main(String[] args) {
        String S = "a", T = "aa";
        String res = new MinimumWindowSubstring_Naive().minWindow(S, T);
        System.out.println(res);
    }
}
