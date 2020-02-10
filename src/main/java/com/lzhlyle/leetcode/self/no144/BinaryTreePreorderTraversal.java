package com.lzhlyle.leetcode.self.no144;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        _preorder(root, res);
        return res;
    }

    private void _preorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        _preorder(node.left, res);
        _preorder(node.right, res);
    }
}
