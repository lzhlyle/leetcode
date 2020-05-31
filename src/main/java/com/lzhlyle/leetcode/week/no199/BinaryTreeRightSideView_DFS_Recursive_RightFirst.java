package com.lzhlyle.leetcode.week.no199;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_DFS_Recursive_RightFirst {
    // dfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(0, root, res);
        return res;
    }

    private void dfs(int level, TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        dfs(level + 1, node.right, res);
        dfs(level + 1, node.left, res);
    }
}
