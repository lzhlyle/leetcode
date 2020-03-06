package com.lzhlyle.leetcode.week.no8;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length, i = 0, sign = 1, total = 0;
        while (i < len && arr[i] == ' ') ++i;
        if (i < len && (arr[i] == '+' || arr[i] == '-')) sign = arr[i++] == '+' ? 1 : -1;
        while (i < len) {
            int digit = arr[i++] - '0';
            if (digit < 0 || digit > 9) break;
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
        }
        return sign * total;
    }
}
