package com.lzhlyle.leetcode.week.no46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_BT {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bt(nums, 0b0, new Integer[nums.length], 0, res);
        return res;
    }

    private void bt(int[] nums, int occupy, Integer[] curr, int ci, List<List<Integer>> res) {
        if (ci == curr.length) {
            res.add(new ArrayList<>(Arrays.asList(curr)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (((occupy >> i) & 1) == 1) continue;
            occupy |= 1 << i;
            curr[ci] = nums[i];
            bt(nums, occupy, curr, ci + 1, res);
            occupy &= ~(1 << i);
        }
    }
}
