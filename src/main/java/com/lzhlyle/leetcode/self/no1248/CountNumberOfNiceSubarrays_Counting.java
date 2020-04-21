package com.lzhlyle.leetcode.self.no1248;

public class CountNumberOfNiceSubarrays_Counting {
    // counting
    // O(n), O(n)
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length, ai = 1; // ai: arr's index
        int[] arr = new int[len + 2]; // odds' indexes
        arr[0] = -1; // begin sentinel
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) arr[ai++] = i;
        }
        arr[ai] = len; // end sentinel

        int cnt = 0;
        for (int i = 1; i + k <= ai; i++) {
            cnt += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return cnt;
    }
}
