package com.lzhlyle.leetcode.week.no7;

public class ReverseInteger_LC {
    public int reverse(int x) {
        int total = 0;
        while (x != 0) {
            int digit = x % 10;
            int tryTotal = total * 10 + digit;
            if ((tryTotal - digit) / 10 != total) return 0;
            total = tryTotal;
            x /= 10;
        }
        return total;
    }
}
