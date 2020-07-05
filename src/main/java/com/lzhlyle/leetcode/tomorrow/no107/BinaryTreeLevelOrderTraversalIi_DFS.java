package com.lzhlyle.leetcode.tomorrow.no107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi_DFS {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, root, res);
        Collections.reverse(res);
        return res;
    }

    private void dfs(int level, TreeNode node, List<List<Integer>> res) {
        if (node == null) return;
        if (res.size() == level) res.add(new ArrayList<>());
        dfs(level + 1, node.left, res);
        dfs(level + 1, node.right, res);
        res.get(level).add(node.val);
    }
}
