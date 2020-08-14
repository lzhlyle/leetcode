package com.lzhlyle.leetcode.week.no349;

import java.util.Arrays;

public class IntersectionOfTwoArrays_TwoPoints {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, ri = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j] && (ri == 0 || nums1[i] != res[ri - 1])) {
                res[ri++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return ri == res.length ? res : Arrays.copyOfRange(res, 0, ri);
    }
}
