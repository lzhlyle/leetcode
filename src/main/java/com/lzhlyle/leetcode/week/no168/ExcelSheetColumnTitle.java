package com.lzhlyle.leetcode.week.no168;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
