package com.lzhlyle.leetcode.recite.no9;

public class PalindromeNumber_LC {
    // 除数
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int div = 1;
        while (x / div >= 10) div *= 10;

        int r = x;
        while (x != 0) {
            if (x % 10 == r / div) {
                x /= 10;
                r %= div;
                div /= 10;
            } else return false;
        }
        return true;
    }
}
