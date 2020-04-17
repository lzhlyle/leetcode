package com.lzhlyle.leetcode.tomorrow.no202;

public class HappyNumber_TwoPoints {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = calc(slow);
            fast = calc(calc(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int calc(int n) {
        int total = 0;
        while (n > 0) {
            int digit = n % 10;
            total += digit * digit;
            n /= 10;
        }
        return total;
    }
}
