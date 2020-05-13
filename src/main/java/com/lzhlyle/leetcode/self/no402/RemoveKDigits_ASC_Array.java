package com.lzhlyle.leetcode.self.no402;

public class RemoveKDigits_ASC_Array {
    public String removeKdigits(String num, int k) {
        int r = 0, n = num.length();
        char[] res = new char[n];
        for (char c : num.toCharArray()) {
            while (r > 0 && k > 0 && res[r - 1] > c) {
                k--;
                r--;
            }
            res[r++] = c;
        }
        while (k-- > 0 && r > 0) r--;

        int l = 0;
        while (l < r && res[l] == '0') l++;
        if (l == r) return "0";
        return new String(res, l, r - l);
    }
}
