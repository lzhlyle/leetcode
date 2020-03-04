package com.lzhlyle.leetcode.tomorrow.no917;

public class ReverseOnlyLetters_TwoPoints {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int len = arr.length, l = 0, r = len - 1;
        if (len < 2) return S;
        while (l < r) {
            while (l < r && !valid(arr[l])) l++;
            while (l < r && !valid(arr[r])) r--;
            if (l < r) {
                arr[l] ^= arr[r];
                arr[r] ^= arr[l];
                arr[l++] ^= arr[r--];
            }
        }
        return new String(arr);
    }

    private boolean valid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}