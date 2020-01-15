package com.lzhlyle.leetcode.tomorrow.no94;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_Recursion {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        _dfs(root, res);
        return res;
    }

    private void _dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        _dfs(node.left, res);
        res.add(node.val);
        _dfs(node.right, res);
    }
}
