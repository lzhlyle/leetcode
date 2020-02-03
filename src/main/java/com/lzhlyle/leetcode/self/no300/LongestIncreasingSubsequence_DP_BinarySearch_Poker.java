package com.lzhlyle.leetcode.self.no300;

public class LongestIncreasingSubsequence_DP_BinarySearch_Poker {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int len;
        if ((len = nums.length) < 2) return len;

        int[] groups = new int[len];
        int groupCnt = 0;
        for (int poker : nums) {
            int groupIndex = _searchGroup(groups, poker, groupCnt);
            if (groupIndex == groupCnt) groupCnt++;
            groups[groupIndex] = poker;
        }
        return groupCnt;
    }

    private int _searchGroup(int[] groups, int poker, int groupCnt) {
        int left = 0, right = groupCnt;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (groups[mid] < poker) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
