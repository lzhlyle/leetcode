package com.lzhlyle.leetcode.recite.no680;

public class ValidPalindromeII_DC_LC {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left++] != arr[right--]) {
                return validPalindrome(arr, left, right + 1) || validPalindrome(arr, left - 1, right);
            }
        }
        return true;
    }

    private boolean validPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left++] != arr[right--]) return false;
        }
        return true;
    }
}
