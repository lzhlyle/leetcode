package com.lzhlyle.leetcode.tomorrow.no349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_BS {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersection(nums2, nums1);
        if (nums1.length == 0) return new int[0];
        Arrays.sort(nums1);
        int ri = 0, n = nums1.length;
        int[] res = new int[n];
        Set<Integer> visited = new HashSet<>();
        for (int v : nums2) {
            if (visited.contains(v)) continue;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums1[mid] < v) l = mid + 1;
                else r = mid;
            }
            if (nums1[l] == v) visited.add(res[ri++] = v);
        }
        return ri == res.length ? res : Arrays.copyOfRange(res, 0, ri);
    }
}
