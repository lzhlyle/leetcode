package com.lzhlyle.leetcode.recite.no300;

import java.util.Arrays;

public class LongestIncreasingSubsequence_DP_BinarySearch {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int len;
        if ((len = nums.length) < 2) return len;

        int[] tails = new int[len]; // worst: desc
        int groupCount = 0;
        for (int num : nums) {
            int groupIndex = Arrays.binarySearch(tails, 0, groupCount, num);
            if (groupIndex < 0) groupIndex = -(groupIndex + 1); // group index
            tails[groupIndex] = num; // append to tail
            if (groupIndex == groupCount) groupCount++;
        }
        return groupCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 6, 20, 80, 21, 26};
        int res = new LongestIncreasingSubsequence_DP_BinarySearch().lengthOfLIS(nums);
        System.out.println(res);
    }
}
