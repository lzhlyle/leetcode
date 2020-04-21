package com.lzhlyle.leetcode.recite.no1248;

public class CountNumberOfNiceSubarrays_LC_TwoPoints_AtMost {
    // two points
    // O(n) O(1)
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] arr, int k) {
        int cnt = 0, l = 0, n = arr.length, odd = 0;
        for (int r = 0; r < n; r++) {
            odd += arr[r] & 1;
            while (odd > k)
                odd -= arr[l++] & 1;
            cnt += r - l + 1; // 将 [l, r] 也算入了
        }
        return cnt;
    }
}
