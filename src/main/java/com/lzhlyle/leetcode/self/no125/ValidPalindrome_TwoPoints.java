package com.lzhlyle.leetcode.self.no125;

public class ValidPalindrome_TwoPoints {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !valid(arr[left])) left++;
            while (left < right && !valid(arr[right])) right--;
            if (left < right && arr[left++] != arr[right--]) return false;
        }
        return true;
    }

    private boolean valid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
