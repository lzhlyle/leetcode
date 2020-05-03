package com.lzhlyle.contest.weekly.weekly186;

public class Contest1 {

    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int zero = 0, one = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j <= i && arr[j] == '0') zero++;
                else if (j > i && arr[j] == '1') one++;
            }
            max = Math.max(max, zero + one);
        }
        return max;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
