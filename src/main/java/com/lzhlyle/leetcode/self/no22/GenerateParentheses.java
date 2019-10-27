package com.lzhlyle.leetcode.self.no22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n < 1) return Collections.emptyList();
        if (n == 1) return Collections.singletonList("()");

        List<String> res = new ArrayList<>();
        // recursion
        this._generate(n, res, 1, "(");

        return res;
    }

    private void _generate(int max, List<String> res, int leftCnt, String curr) {
        // terminator
        if (curr.length() >= max * 2) {
            res.add(curr);
            return;
        }

        // process
        // drill down
        if (leftCnt < max) {
            this._generate(max, res, leftCnt + 1, curr + "(");
        }

        if (curr.length() - leftCnt < leftCnt) {
            this._generate(max, res, leftCnt, curr + ")");
        }

        // reverse state
    }
}