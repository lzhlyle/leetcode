package com.lzhlyle.leetcode.tomorrow.no404;

import java.util.Stack;

public class SumOfLeftLeaves_Iteration {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    res += node.left.val;
                else stack.push(node.left);
            }
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }
}
