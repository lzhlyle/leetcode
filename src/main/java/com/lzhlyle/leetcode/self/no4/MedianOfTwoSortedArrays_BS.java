package com.lzhlyle.leetcode.self.no4;

public class MedianOfTwoSortedArrays_BS {
    // O(log(min(m, n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, lCnt = (m + n + 1) / 2;
        if (m > n) return findMedianSortedArrays(nums2, nums1);

        // 只对 min(m, n) 二分
        int l = 0, r = m;
        while (l < r) {
            int i = l + (r - l) / 2, j = lCnt - i;
            if (nums1[i] < nums2[j - 1]) l = i + 1;
            else r = i;
        }
        int i = l, j = lCnt - i;

        int l1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int r1 = i == m ? Integer.MAX_VALUE : nums1[i];
        int l2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int r2 = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) & 1) == 1) return Math.max(l1, l2);
        return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
    }
}
