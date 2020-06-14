package com.lzhlyle.leetcode.week.no1248;

public class CountNumberOfNiceSubarrays_LC_PrefixSum {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, odd = 0, cnt = 0;
        int[] freq = new int[n + 1];
        freq[0] = 1;
        for (int num : nums) {
            odd += num & 1;
            freq[odd]++;
            if (odd >= k) cnt += freq[odd - k];
        }
        return cnt;
    }
}
