package com.lzhlyle.leetcode.self.no1071;

public class GreatestCommonDivisorOfStrings_Recursion {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        if (len2 == 0) return str1;
        if (len1 < len2) return gcdOfStrings(str2, str1);
        if (str1.indexOf(str2) != 0) return "";
        return gcdOfStrings(str1.substring(len2), str2);
    }
}
