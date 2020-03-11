package com.lzhlyle.leetcode.tomorrow.no47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi_BT_Pruning {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        bt(nums, new Integer[nums.length], 0, new boolean[nums.length], res);
        return res;
    }

    private void bt(int[] nums, Integer[] curr, int ci, boolean[] used, List<List<Integer>> res) {
        if (ci == curr.length) {
            res.add(new ArrayList<>(Arrays.asList(curr)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i]) continue;
            used[i] = true;
            curr[ci] = nums[i];
            bt(nums, curr, ci + 1, used, res);
            used[i] = false;
        }
    }
}
