package com.lzhlyle.leetcode.week.no78;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < 1 << len; i++) {
            List<Integer> adding = new LinkedList<>();
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) adding.add(nums[j]);
            }
            res.add(adding);
        }
        return res;
    }
}
