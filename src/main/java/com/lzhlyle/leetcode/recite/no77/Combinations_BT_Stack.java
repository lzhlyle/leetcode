package com.lzhlyle.leetcode.recite.no77;

import java.util.*;

public class Combinations_BT_Stack {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return Collections.emptyList();
        res = new LinkedList<>();
        bt(n, k, 1, new Stack<>());
        return res;
    }

    private void bt(int n, int k, int num, Stack<Integer> stack) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (num > n || k - stack.size() - 1 > n - num) return;
        // include
        stack.push(num);
        bt(n, k, num + 1, stack);
        // exclude
        stack.pop();
        bt(n, k, num + 1, stack);
    }
}
