package com.lzhlyle.leetcode.recite.no680;

public class ValidPalindromeII_DC {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        return validPalindrome(arr, 0, arr.length - 1, 1);
    }

    private boolean validPalindrome(char[] arr, int left, int right, int chance) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                if (chance <= 0) return false;
                // dc
                return validPalindrome(arr, left + 1, right, chance - 1)
                        || validPalindrome(arr, left, right - 1, chance - 1);
            }
            left++;
            right--;
        }
        return true;
    }
}
