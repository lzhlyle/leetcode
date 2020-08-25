package com.lzhlyle.leetcode.tomorrow.no118;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>(n);
        List<Integer> list = new ArrayList<>(n);
        while (n-- > 0) {
            list.add(0, 1);
            for (int i = 1; i < list.size() - 1; i++)
                list.set(i, list.get(i) + list.get(i + 1));
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
