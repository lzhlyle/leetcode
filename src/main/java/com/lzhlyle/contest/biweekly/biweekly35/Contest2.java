package com.lzhlyle.contest.biweekly.biweekly35;

import java.util.Arrays;

public class Contest2 {
    private static final int MOD = 1000000007;

    // 按频繁程度排列
    public int maxSumRangeQuery(int[] nums, int[][] req) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] arr = new int[n + 1];
        for (int[] r : req) {
            arr[r[0]]++;
            arr[r[1] + 1]--;
        }

        int[] freq = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            freq[i] = sum;
        }
        Arrays.sort(freq);

        long res = 0;
        for (int i = n - 1; i >= 0 && freq[i] > 0; i--) {
            res += freq[i] * nums[i];
            res %= MOD;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
