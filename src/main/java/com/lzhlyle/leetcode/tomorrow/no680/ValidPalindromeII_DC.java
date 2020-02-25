package com.lzhlyle.leetcode.tomorrow.no680;

public class ValidPalindromeII_DC {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left++] != arr[right--]) {
                return valid(arr, left - 1, right) || valid(arr, left, right + 1);
            }
        }
        return true;
    }

    private boolean valid(char[] arr, int l, int r) {
        while (l < r) {
            if (arr[l++] != arr[r--]) return false;
        }
        return true;
    }
}
