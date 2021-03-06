package com.lzhlyle.leetcode.week.no312;

public class BurstBalloons_Recursion_LC_DC {
    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] arr = new int[len];
        arr[0] = arr[len - 1] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        return dc(arr, 0, len - 1, new int[len][len]);
    }

    private int dc(int[] arr, int l, int r, int[][] memo) {
        if (l + 1 >= r) return 0;
        if (memo[l][r] > 0) return memo[l][r];
        int max = 0;
        for (int i = l + 1; i < r; i++) {
            int curr = dc(arr, l, i, memo) + dc(arr, i, r, memo) + arr[l] * arr[i] * arr[r];
            if (curr > max) max = curr;
        }
        return memo[l][r] = max;
    }
}
