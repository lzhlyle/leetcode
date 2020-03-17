package com.lzhlyle.leetcode.tomorrow.no1071;

public class GreatestCommonDivisorOfStrings_Recursion {
    public String gcdOfStrings(String str1, String str2) {
        if (str2.isEmpty()) return str1;
        if (str2.length() > str1.length()) return gcdOfStrings(str2, str1);
        if (str1.indexOf(str2) != 0) return "";
        return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}
