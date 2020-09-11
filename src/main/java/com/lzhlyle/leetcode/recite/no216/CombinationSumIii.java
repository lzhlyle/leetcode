package com.lzhlyle.leetcode.recite.no216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CombinationSumIii {
    // 和为 n，k 个 数
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 45 || n < 1) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        bt(1, new Stack<>(), k, n, res);
        return res;
    }

    private void bt(int i, Stack<Integer> curr, int k, int rest, List<List<Integer>> res) {
        if (k == 0) {
            if (rest == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int j = i; j < 10 && j <= rest; j++) {
            curr.push(j);
            bt(j + 1, curr, k - 1, rest - j, res);
            curr.pop();
        }
    }
}
