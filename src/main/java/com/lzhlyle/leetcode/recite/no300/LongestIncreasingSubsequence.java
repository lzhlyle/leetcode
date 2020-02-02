package com.lzhlyle.leetcode.recite.no300;

public class LongestIncreasingSubsequence {
    // brute force
    public int lengthOfLIS(int[] nums) {
        return _lis(nums, Integer.MIN_VALUE, 0);
    }

    private int _lis(int[] nums, int lastVal, int currIndex) {
        // terminator
        if (currIndex == nums.length) return 0;

        // process
        // drill down
        int taken = 0;
        if (nums[currIndex] > lastVal) {
            taken = this._lis(nums, nums[currIndex], currIndex + 1) + 1;
        }
        int untaken = this._lis(nums, lastVal, currIndex + 1);
        return Math.max(taken, untaken);

        // reverse state
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 4};
        int res = new LongestIncreasingSubsequence().lengthOfLIS(nums);
        System.out.println(res);
    }
}
