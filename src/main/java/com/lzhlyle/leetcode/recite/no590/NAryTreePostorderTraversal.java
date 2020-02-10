package com.lzhlyle.leetcode.recite.no590;

import java.util.LinkedList;
import java.util.List;

public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        _postOrder(root, res);
        return res;
    }

    private void _postOrder(Node node, List<Integer> res) {
        if (node == null) return;
        List<Node> children = node.children;
        for (Node child : children) _postOrder(child, res);
        res.add(node.val);
    }
}
