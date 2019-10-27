package com.lzhlyle.leetcode.recite.no22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n < 1) return Collections.emptyList();
        if (n == 1) return Collections.singletonList("()");

        // recursion
        List<String> res = new ArrayList<>();
        this._generate(1, n, res, "(");
        return res;
    }

    private void _generate(int leftCnt, int max, List<String> res, String curr) {
        // terminator
        if (curr.length() >= max * 2) {
            res.add(curr);
            return;
        }

        // process
        // drill down
        if (leftCnt < max) {
            this._generate(leftCnt + 1, max, res, curr + "(");
        }

        if (curr.length() < leftCnt * 2) {
            this._generate(leftCnt, max, res, curr + ")");
        }
        // reverse state
    }
}