package com.lzhlyle.leetcode.week.no662;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree_DFS {
    private int max;

    public int widthOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(0, root, 0, new ArrayList<>());
        return max;
    }

    private void dfs(int level, TreeNode node, int col, List<Integer> lefts) {
        if (node == null) return;
        if (lefts.size() == level) lefts.add(col);
        max = Math.max(max, col - lefts.get(level) + 1);
        dfs(level + 1, node.left, col * 2, lefts);
        dfs(level + 1, node.right, col * 2 + 1, lefts);
    }
}
