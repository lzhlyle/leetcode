package com.lzhlyle.leetcode.self.no168;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--; // !important
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
