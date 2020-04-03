package com.lzhlyle.leetcode.tomorrow.no9;

public class PalindromeNumber_LC_Reverse_Half {
    // 反转一半
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int r = 0;
        while (x > r) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return x == r || x == r / 10; // even / odd
    }
}
