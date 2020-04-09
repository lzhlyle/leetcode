package com.lzhlyle.leetcode.week.no22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_DFS {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, "", res);
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
