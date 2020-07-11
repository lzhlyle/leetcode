package com.lzhlyle.contest.biweekly.biweekly30;

import java.util.Arrays;

public class Contest2 {
    private static final int MOD = 1000000007;

    // brute force
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n * (n + 1) / 2];
        arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
            arr[i] = nums[i];
        }
        int ai = n;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                arr[ai++] = nums[i] - nums[j];
            }
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = left - 1; i < right; i++) {
            res += arr[i] % MOD;
            res %= MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
