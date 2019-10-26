package com.lzhlyle.leetcode.recite.no242;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        // 暴力解：排序，比较字符串 O(nlog(n))

        // 排序 O(log(n))
        char[] sCharArr = s.toCharArray();
        Arrays.sort(sCharArr);

        char[] tCharArr = t.toCharArray();
        Arrays.sort(tCharArr);

        // 比较 O(n)
        return Arrays.equals(sCharArr, tCharArr);
    }
}
