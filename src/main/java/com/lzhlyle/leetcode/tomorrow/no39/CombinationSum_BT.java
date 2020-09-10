package com.lzhlyle.leetcode.tomorrow.no39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum_BT {
    // bt
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        bt(candidates, 0, new Stack<>(), target, res);
        return res;
    }

    private void bt(int[] arr, int i, Stack<Integer> curr, int rest, List<List<Integer>> res) {
        if (rest == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < arr.length && arr[j] <= rest; j++) {
            curr.push(arr[j]);
            bt(arr, j, curr, rest - arr[j], res);
            curr.pop();
        }
    }
}
