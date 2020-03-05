package com.lzhlyle.leetcode.recite.no77;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Combinations_BT {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return Collections.emptyList();
        res = new LinkedList<>();
        bt(n, k, 1, new ArrayList<>(1));
        return res;
    }

    private void bt(int n, int k, int num, List<Integer> curr) {
        if (curr.size() == k) {
            res.add(curr);
            return;
        }
        if (num > n || k - curr.size() - 1 > n - num) return;
        // exclude
        bt(n, k, num + 1, new LinkedList<>(curr));
        // include
        curr.add(num);
        bt(n, k, num + 1, new LinkedList<>(curr));
    }
}
