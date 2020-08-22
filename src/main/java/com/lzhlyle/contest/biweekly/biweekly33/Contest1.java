package com.lzhlyle.contest.biweekly.biweekly33;

public class Contest1 {
    // O(n)
    public String thousandSeparator(int n) {
        if (n < 1000) return String.valueOf(n);
        char[] arr = String.valueOf(n).toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1, cnt = 1; i >= 0; i--, cnt++) {
            if (cnt % 3 == 1) builder.append(".");
            builder.append(arr[i]);
        }
        return builder.reverse().toString().substring(0, builder.length() - 1);
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
