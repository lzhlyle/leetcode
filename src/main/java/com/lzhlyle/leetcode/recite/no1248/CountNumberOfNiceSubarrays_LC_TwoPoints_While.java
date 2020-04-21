package com.lzhlyle.leetcode.recite.no1248;

public class CountNumberOfNiceSubarrays_LC_TwoPoints_While {
    // two points
    // O(n) O(1)
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, l = 0, r = -1, odd = 0, cnt = 0;
        while (r + 1 < n) {
            while (r + 1 < n && odd < k) odd += nums[++r] & 1;

            // r == n || odd == k
            int tag = r;
            while (r + 1 < n && (nums[r + 1] & 1) == 0) ++r;
            while (l <= r && odd == k) {
                cnt += r - tag + 1;
                odd -= nums[l++] & 1;
            }
        }
        return cnt;
    }
}
