package com.lzhlyle.leetcode.self.no589;

import java.util.LinkedList;
import java.util.List;

public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        _preOrder(root, res);
        return res;
    }

    private void _preOrder(Node node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        for (Node n : node.children) _preOrder(n, res);
    }
}
