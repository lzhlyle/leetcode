package com.lzhlyle.leetcode.self.no47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi_BT_Pruning {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        bt(0, nums, new Integer[nums.length], new boolean[nums.length], res);
        return res;
    }

    private void bt(int level, int[] nums, Integer[] curr, boolean[] used, List<List<Integer>> res) {
        if (level == nums.length) {
            res.add(new ArrayList<>(Arrays.asList(curr)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            curr[level] = nums[i];
            bt(level + 1, nums, curr, used, res);
            used[i] = false;
        }
    }
}
