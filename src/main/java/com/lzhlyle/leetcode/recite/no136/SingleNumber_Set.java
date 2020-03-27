package com.lzhlyle.leetcode.recite.no136;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber_Set {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        int res = 0;
        for (Integer single : set) res = single;
        return res;
    }
}
