package com.lzhlyle.leetcode.self.no40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumIi_BT {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (j > i && arr[j] == arr[j - 1]) continue; // 去重
            curr.push(arr[j]);
            bt(arr, j + 1, curr, rest - arr[j], res);
            curr.pop();
        }
    }
}
