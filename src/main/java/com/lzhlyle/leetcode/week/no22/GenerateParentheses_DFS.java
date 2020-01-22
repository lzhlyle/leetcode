package com.lzhlyle.leetcode.week.no22;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses_DFS {
    public List<String> generateParenthesis(int n) {
        if (n < 1) return Collections.emptyList();
        if (n == 1) return Collections.singletonList("()");
        List<String> res = new LinkedList<>();
        dfs(n, 1, "(", res);
        return res;
    }

    private void dfs(int n, int leftCnt, String curr, List<String> res) {
        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }

        if (leftCnt < n) dfs(n, leftCnt + 1, curr + "(", res);
        if (curr.length() < 2 * leftCnt) dfs(n, leftCnt, curr + ")", res);
    }
}
