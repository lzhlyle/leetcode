package com.lzhlyle.leetcode.recite.no491;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IncreasingSubsequences_LC {
    public List<List<Integer>> findSubsequences(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        bt(0, arr, new Stack<>(), res);
        return res;
    }

    public void bt(int i, int[] arr, Stack<Integer> stack, List<List<Integer>> res) {
        if (i == arr.length) {
            if (stack.size() > 1)
                res.add(new ArrayList<>(stack));
            return;
        }

        if (stack.isEmpty() || arr[i] >= stack.peek()) {
            stack.push(arr[i]);
            bt(i + 1, arr, stack, res);
            stack.pop();
        }

        if (stack.isEmpty() || arr[i] != stack.peek())
            bt(i + 1, arr, stack, res);
    }
}
