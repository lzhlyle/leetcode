package com.lzhlyle.contest.weekly.weekly201;

public class Contest1 {
    private static final int dis = 'a' - 'A';

    public String makeGood(String s) {
        if (s.isEmpty() || s.length() == 1) return s;

        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean ok = true;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                builder.append(arr[i]);
            } else if (Math.abs(arr[i] - arr[i + 1]) == dis) {
                ok = false;
                i++;
            } else {
                builder.append(arr[i]);
            }
        }
        if (ok) return builder.toString();
        return makeGood(builder.toString());
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
