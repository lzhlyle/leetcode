package com.lzhlyle.leetcode.recite.no202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_Recursion {
    private Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        int total = 0;
        while (n > 0) {
            total += square(n % 10);
            n /= 10;
        }
        if (total == 1) return true;
        if (set.contains(total)) return false;
        set.add(total);
        return isHappy(total);
    }

    private int square(int num) {
        switch (num) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 4;
            case 3:
                return 9;
            case 4:
                return 16;
            case 5:
                return 25;
            case 6:
                return 36;
            case 7:
                return 49;
            case 8:
                return 64;
            case 9:
                return 81;
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean res = new HappyNumber_Recursion().isHappy(19);
        System.out.println(res);
    }
}
