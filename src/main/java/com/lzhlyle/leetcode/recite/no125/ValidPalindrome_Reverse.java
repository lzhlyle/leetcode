package com.lzhlyle.leetcode.recite.no125;

public class ValidPalindrome_Reverse {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder builder = new StringBuilder(str).reverse();
        return str.equals(builder.toString());
    }
}
