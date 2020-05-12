package com.lzhlyle.leetcode.self.no1248;

public class CountNumberOfNiceSubarrays_LC_PrefixSum {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, odd = 0, cnt = 0;
        int[] arr = new int[n + 1];
        arr[odd]++;
        for (int num : nums) {
            odd += num & 1;
            arr[odd]++;
            if (odd >= k) cnt += arr[odd - k];
        }
        return cnt;
    }
}
