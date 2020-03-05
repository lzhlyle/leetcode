package com.lzhlyle.leetcode.self.no77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Combinations_BT_Stack {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        bt(n, k, 1, new Stack<>());
        return res;
    }

    private void bt(int n, int k, int num, Stack<Integer> stack) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (k > n || k - stack.size() - 1 > n - num) return;
        stack.push(num);
        bt(n, k, num + 1, stack);
        stack.pop();
        bt(n, k, num + 1, stack);
    }
}
