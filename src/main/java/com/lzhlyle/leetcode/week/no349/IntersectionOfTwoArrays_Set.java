package com.lzhlyle.leetcode.week.no349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_Set {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersection(nums2, nums1);

        Set<Integer> set = new HashSet<>(), visited = new HashSet<>();
        for (int v : nums1) set.add(v);

        int[] res = new int[nums1.length];
        int i = 0;
        for (int v : nums2)
            if (set.contains(v) && !visited.contains(v))
                visited.add(res[i++] = v);

        return Arrays.copyOfRange(res, 0, i);
    }
}
