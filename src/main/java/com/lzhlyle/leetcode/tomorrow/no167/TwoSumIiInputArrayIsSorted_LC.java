package com.lzhlyle.leetcode.tomorrow.no167;

public class TwoSumIiInputArrayIsSorted_LC {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1, sum;
        while ((sum = numbers[l] + numbers[r]) != target) {
            if (sum > target) r--;
            else l++;
        }
        return new int[]{l + 1, r + 1};
    }
}
