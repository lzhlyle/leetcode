package com.lzhlyle.leetcode.recite.no350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysIi_Map_Freq_LC {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
        }

        int[] arr = new int[nums1.length];
        int i = 0;
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            if (cnt-- > 0) {
                arr[i++] = num;
                map.put(num, cnt);
            }
        }
        return Arrays.copyOfRange(arr, 0, i);
    }
}
