package com.lzhlyle.leetcode.tomorrow.no257;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths_BT {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        bt(root, new Stack<>(), res);
        return res;
    }

    private void bt(TreeNode node, Stack<Integer> stack, List<String> res) {
        if (node == null) return;
        stack.push(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (Integer v : stack)
                builder.append(v).append("->");
            res.add(builder.substring(0, builder.length() - 2));
        } else {
            bt(node.left, stack, res);
            bt(node.right, stack, res);
        }
        stack.pop();
    }
}
