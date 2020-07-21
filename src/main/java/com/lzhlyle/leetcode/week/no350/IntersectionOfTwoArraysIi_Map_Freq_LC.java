package com.lzhlyle.leetcode.week.no350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysIi_Map_Freq_LC {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums1)
            map.put(v, map.getOrDefault(v, 0) + 1);

        int[] res = new int[nums1.length];
        int i = 0;
        for (int v : nums2) {
            if (map.containsKey(v)) {
                res[i++] = v;
                int cnt = map.get(v);
                if (cnt == 1) map.remove(v);
                else map.put(v, cnt - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, i);
    }
}
