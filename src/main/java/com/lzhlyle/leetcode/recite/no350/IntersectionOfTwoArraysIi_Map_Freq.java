package com.lzhlyle.leetcode.recite.no350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysIi_Map_Freq {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int v : nums1) {
            if (!map1.containsKey(v)) map1.put(v, 0);
            map1.put(v, map1.get(v) + 1);
        }
        for (int v : nums2) {
            if (!map2.containsKey(v)) map2.put(v, 0);
            map2.put(v, map2.get(v) + 1);
        }

        if (map1.size() > map2.size()) {
            Map swap = map1;
            map1 = map2;
            map2 = swap;
        }

        List<Integer> list = new ArrayList<>();
        for (Integer k : map1.keySet()) {
            if (map2.containsKey(k)) {
                int min = Math.min(map1.get(k), map2.get(k));
                while (min-- > 0) list.add(k);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int e : list) res[i++] = e;
        return res;
    }
}
