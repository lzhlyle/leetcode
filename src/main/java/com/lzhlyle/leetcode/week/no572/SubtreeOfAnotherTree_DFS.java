package com.lzhlyle.leetcode.tomorrow.no572;

import java.util.Stack;

public class SubtreeOfAnotherTree_DFS {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = find(s, t.val, new Stack<>());
        while (!stack.isEmpty()) {
            if (valid(stack.pop(), t)) return true;
        }
        return false;
    }

    private boolean valid(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return valid(s.left, t.left) && valid(s.right, t.right);
    }

    private Stack<TreeNode> find(TreeNode root, int target, Stack<TreeNode> stack) {
        if (root == null) return stack;
        if (root.val == target) stack.push(root);
        find(root.left, target, stack);
        find(root.right, target, stack);
        return stack;
    }
}
