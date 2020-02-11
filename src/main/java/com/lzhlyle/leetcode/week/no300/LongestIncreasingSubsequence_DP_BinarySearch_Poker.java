package com.lzhlyle.leetcode.week.no300;

public class LongestIncreasingSubsequence_DP_BinarySearch_Poker {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, cnt = 0;
        if (len < 2) return len;
        int[] groups = new int[len];
        for (int num : nums) {
            int i = _searchGroup(groups, num, cnt);
            groups[i] = num;
            if (i == cnt) cnt++;
        }
        return cnt;
    }

    private int _searchGroup(int[] groups, int target, int cnt) {
        int left = 0, right = cnt;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (groups[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
