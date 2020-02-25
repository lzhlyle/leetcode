package com.lzhlyle.leetcode.recite.no88;

public class MergeSortedArray_Backward {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ti = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[ti--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) nums1[ti--] = nums1[i--];
        while (j >= 0) nums1[ti--] = nums2[j--];
    }
}
