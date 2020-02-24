package com.lzhlyle.leetcode.recite.no189;

import java.util.Arrays;

public class RotateArray_BruteForce {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        for (int i = 0; i < k; i++) {
            int prev = nums[len - 1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = prev;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray_BruteForce().rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
