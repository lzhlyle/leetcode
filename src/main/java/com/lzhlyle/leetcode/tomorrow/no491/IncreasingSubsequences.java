package com.lzhlyle.leetcode.self.no491;

import java.util.*;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        bt(arr, 0, new Stack<>(), res);
        return res;
    }

    private void bt(int[] arr, int i, Stack<Integer> curr, List<List<Integer>> res) {
        if (curr.size() > 1) res.add(new ArrayList<>(curr));
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < arr.length; j++) {
            if (set.add(arr[j])) {
                if (curr.isEmpty() || arr[j] >= curr.peek()) {
                    curr.push(arr[j]);
                    bt(arr, j + 1, curr, res);
                    curr.pop();
                }
            }
        }
    }
}
