package com.lzhlyle.leetcode.tomorrow.no114;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList_Stack {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (curr.right != null) stk.push(curr.right);
            if (curr.left != null) stk.push(curr.left);
            if (!stk.isEmpty()) curr.right = stk.peek();
            curr.left = null;
        }
    }
}
