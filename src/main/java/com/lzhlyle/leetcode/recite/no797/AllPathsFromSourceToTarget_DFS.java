package com.lzhlyle.leetcode.recite.no797;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourceToTarget_DFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> curr = new Stack<>();
        curr.push(0);
        dfs(0, g, curr, res);
        return res;
    }

    private void dfs(int i, int[][] g, Stack<Integer> curr, List<List<Integer>> res) {
        if (i == g.length - 1) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j : g[i]) {
            curr.push(j);
            dfs(j, g, curr, res);
            curr.pop();
        }
    }
}
