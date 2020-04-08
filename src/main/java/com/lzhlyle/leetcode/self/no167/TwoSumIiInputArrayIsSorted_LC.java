package com.lzhlyle.leetcode.self.no167;

public class TwoSumIiInputArrayIsSorted_LC {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] < target) l++;
            else r--;
        }
        return new int[]{l + 1, r + 1};
    }
}
