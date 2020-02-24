package com.lzhlyle.leetcode.self.no680;

public class ValidPalindromeII_DC {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left++] != arr[right--]) {
                return valid(arr, left, right + 1) || valid(arr, left - 1, right);
            }
        }
        return true;
    }

    private boolean valid(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left++] != arr[right--]) return false;
        }
        return true;
    }
}
