package com.lzhlyle.leetcode.recite.no515;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(0, root, res);
        return res;
    }

    private void dfs(int level, TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        else res.set(level, Math.max(res.get(level), node.val));
        dfs(level + 1, node.left, res);
        dfs(level + 1, node.right, res);
    }
}
