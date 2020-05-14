package com.lzhlyle.leetcode.week.no137;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberIi_Set {
    // O(n), O(n)
    public int singleNumber(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        Set<Integer> nonUniqueSet = new HashSet<>();
        for (int num : nums) {
            if (uniqueSet.contains(num)) {
                uniqueSet.remove(num);
                nonUniqueSet.add(num);
            } else if (!nonUniqueSet.contains(num)) {
                uniqueSet.add(num);
            }
        }
        for (Integer v : uniqueSet) return v;
        throw new RuntimeException("single number can not be found.");
    }
}
