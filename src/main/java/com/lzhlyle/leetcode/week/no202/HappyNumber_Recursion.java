package com.lzhlyle.leetcode.week.no202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_Recursion {
    private Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (set.contains(n)) return false;
        set.add(n);
        return isHappy(calc(n));
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
