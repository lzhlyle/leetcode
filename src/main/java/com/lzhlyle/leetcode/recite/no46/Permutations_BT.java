package com.lzhlyle.leetcode.recite.no46;

import java.util.*;

public class Permutations_BT {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) return Collections.emptyList();

        List<List<Integer>> res = new LinkedList<>();
        bt(nums, new Integer[len], 0, 0b0, res);
        return res;
    }

    private void bt(int[] nums, Integer[] curr, int ci, int occupy, List<List<Integer>> res) {
        if (occupy == (1 << nums.length) - 1) {
            res.add(new ArrayList<>(Arrays.asList(curr)));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (((occupy >> i) & 1) == 1) continue;
            occupy |= 1 << i;
            curr[ci] = nums[i];
            bt(nums, curr, ci + 1, occupy, res);
            occupy &= (~(1 << i));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Permutations_BT().permute(nums);
        System.out.println(res);
    }
}
