package com.lzhlyle.contest.biweekly.biweekly35;

public class Contest1 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] pre = new int[arr.length + 1];
        for (int i = 1; i < pre.length; i++)
            pre[i] = pre[i - 1] + arr[i - 1];

        int res = 0;
        for (int i = 1; i < pre.length; i++) {
            int base = pre[i - 1];
            for (int j = i; j < pre.length; j += 2) {
                res += pre[j] - base;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
