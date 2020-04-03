package com.lzhlyle.leetcode.tomorrow.no205;

public class IsomorphicStrings_Array_LC {
    public boolean isIsomorphic(String s, String t) {
        int[] from = new int[256], to = new int[256];
        char[] arrS = s.toCharArray(), arrT = t.toCharArray();
        for (int i = 0; i < arrS.length; i++) {
            char chS = arrS[i], chT = arrT[i];
            if (from[chS] != to[chT]) return false;
            if (from[chS] == 0) from[chS] = to[chT] = i + 1; // exclude 0
        }
        return true;
    }
}
