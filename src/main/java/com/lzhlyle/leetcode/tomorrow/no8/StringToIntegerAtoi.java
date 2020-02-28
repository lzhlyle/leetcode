package com.lzhlyle.leetcode.tomorrow.no8;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length, i = 0, sign = 1, total = 0;
        if (len < 1) return 0;
        while (i < len && arr[i] == ' ') ++i;
        if (i < len && (arr[i] == '+' || arr[i] == '-')) {
            if (arr[i++] == '-') sign = -1;
        }
        while (i < len) {
            int digit = arr[i++] - '0';
            if (digit < 0 || digit > 9) break;
            if (Integer.MAX_VALUE / 10 < total ||
                    (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
        }
        return total * sign;
    }
}
