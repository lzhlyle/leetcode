package com.lzhlyle.leetcode.recite.no8;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        int len = str.length(), i = 0, sign = 1, total = 0;
        if (len < 1) return 0;
        
        while (i < len && str.charAt(i) == ' ') i++;

        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        while (i < len) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) break;
            if (Integer.MAX_VALUE / 10 < total ||
                    (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            i++;
        }
        return total * sign;
    }
}
