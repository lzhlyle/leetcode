package com.lzhlyle.leetcode.self.no1248;

public class CountNumberOfNiceSubarrays_LC_TwoPoints_ForEach {
    // two points
    // O(n) O(1)
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0, l = 0, count = 0, odd = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                odd++;
                count = 0; // reset
            }

            while (odd == k) {
                odd -= nums[l++] & 1;
                count++;
            }

            res += count;
        }
        return res;
    }
}
