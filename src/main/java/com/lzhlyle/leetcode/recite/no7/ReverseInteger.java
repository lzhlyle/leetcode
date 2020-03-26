package com.lzhlyle.leetcode.recite.no7;

public class ReverseInteger {
    public int reverse(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int begin = 0, sign = 1;
        if (arr[0] == '-') {
            begin = 1;
            sign = -1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= begin; i--) {
            builder.append(arr[i]);
        }
        long res = Long.valueOf(builder.toString()) * sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }
}
