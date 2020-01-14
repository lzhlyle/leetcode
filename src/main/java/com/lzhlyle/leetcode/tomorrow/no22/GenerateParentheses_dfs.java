package com.lzhlyle.leetcode.tomorrow.no22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses_dfs {
    // dfs
    public List<String> generateParenthesis(int n) {
        if (n < 1) return Collections.emptyList();
        if (n == 1) return Collections.singletonList("()");

        List<String> result = new ArrayList<>();
        _generate(n, result, 1, "(");
        return result;
    }

    private void _generate(int max, List<String> result, int leftCnt, String curr) {
        if (curr.length() >= (max << 1)) {
            result.add(curr);
            return;
        }

        if (leftCnt < max) _generate(max, result, leftCnt + 1, curr + "(");
        if (curr.length() < (leftCnt << 1)) _generate(max, result, leftCnt, curr + ")");
    }
}