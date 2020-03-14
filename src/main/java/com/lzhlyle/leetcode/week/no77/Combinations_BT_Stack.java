package com.lzhlyle.leetcode.week.no77;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations_BT_Stack {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        bt(n, k, 1, new Stack<>(), res);
        return res;
    }

    private void bt(int n, int k, int num, Stack<Integer> stack, List<List<Integer>> res) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (k - stack.size() - 1 > n - num) return;
        stack.push(num);
        bt(n, k, num + 1, stack, res);
        stack.pop();
        bt(n, k, num + 1, stack, res);
    }
}
