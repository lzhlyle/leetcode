package com.lzhlyle.leetcode.week.no1071;

import java.util.Objects;

public class GreatestCommonDivisorOfStrings_Math {
    public String gcdOfStrings(String str1, String str2) {
        if (!Objects.equals(str1 + str2, str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
