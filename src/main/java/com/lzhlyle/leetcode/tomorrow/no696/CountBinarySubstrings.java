package com.lzhlyle.leetcode.tomorrow.no696;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s.length() == 1) return 0;
        char[] arr = s.toCharArray();
        int cnt = 0, a = 1, b = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                a++;
            } else {
                cnt += Math.min(a, b);
                b = a;
                a = 1;
            }
        }
        cnt += Math.min(a, b);
        return cnt;
    }
}
