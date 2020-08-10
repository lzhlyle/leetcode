package com.lzhlyle.leetcode.self.no171;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (char c : s.toCharArray())
            res = res * 26 + ((c - 'A') + 1);
        return res;
    }
}
