package com.lzhlyle.leetcode.self.no515;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        else res.set(level, Math.max(res.get(level), node.val));
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}
