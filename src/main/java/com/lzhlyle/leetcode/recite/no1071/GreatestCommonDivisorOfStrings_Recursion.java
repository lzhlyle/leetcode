package com.lzhlyle.leetcode.recite.no1071;

public class GreatestCommonDivisorOfStrings_Recursion {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        if (str1.length() < str2.length()) return gcdOfStrings(str2, str1);
        if (str2.isEmpty()) return str1;
        return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}
