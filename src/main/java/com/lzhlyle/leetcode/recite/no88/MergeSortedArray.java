package com.lzhlyle.leetcode.recite.no88;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int ti = 0, i = 0, j = 0;
        while (i < m && j < n) {
            temp[ti++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) temp[ti++] = nums1[i++];
        while (j < n) temp[ti++] = nums2[j++];
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }
}
