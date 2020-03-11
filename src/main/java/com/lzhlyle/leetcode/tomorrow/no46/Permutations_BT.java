package com.lzhlyle.leetcode.tomorrow.no46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_BT {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bt(nums, new Integer[nums.length], 0, 0b0, res);
        return res;
    }

    private void bt(int[] nums, Integer[] curr, int ci, int occupy, List<List<Integer>> res) {
        if (ci == curr.length) {
            res.add(new ArrayList<>(Arrays.asList(curr)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (((occupy >> i) & 1) == 1) continue;
            occupy |= 1 << i;
            curr[ci] = nums[i];
            bt(nums, curr, ci + 1, occupy, res);
            occupy &= ~(1 << i);
        }
    }
}
