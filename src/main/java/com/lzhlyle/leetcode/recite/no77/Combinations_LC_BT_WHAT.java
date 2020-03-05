package com.lzhlyle.leetcode.recite.no77;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Combinations_LC_BT_WHAT {
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return Collections.emptyList();

        List<List<Integer>> result = new LinkedList<>();
        if (k == 0) {
            result.add(new LinkedList<>());
            return result;
        }

        // include
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) list.add(n);

        // exclude
        result.addAll(combine(n - 1, k));
        return result;
    }
}
