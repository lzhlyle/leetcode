package com.lzhlyle.leetcode.recite.no9;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int b = 1, d = 10;
        while (x / b != 0) {
            if (b > Integer.MAX_VALUE / 10) {
                d = 1;
                break;
            }
            b *= 10;
        }
        b /= d; // 退一位

        int r = x;
        while (x != 0) {
            if (x % 10 == r / b) {
                x /= 10;
                r %= b;
                b /= 10;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new PalindromeNumber().isPalindrome(1000000001);
        System.out.println(res);
    }
}
