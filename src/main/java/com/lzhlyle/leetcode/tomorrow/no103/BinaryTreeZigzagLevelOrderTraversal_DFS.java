package com.lzhlyle.leetcode.tomorrow.no103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_DFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, root, res);
        for (int i = 1; i < res.size(); i += 2)
            Collections.reverse(res.get(i));
        return res;
    }

    private void dfs(int level, TreeNode node, List<List<Integer>> res) {
        if (node == null) return;
        if (level == res.size()) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        dfs(level + 1, node.left, res);
        dfs(level + 1, node.right, res);
    }
}
