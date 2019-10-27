package com.lzhlyle.leetcode.recite.no94;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // base condition
        if (root == null) return Collections.emptyList();
        if (root.left == null && root.right == null) return Collections.singletonList(root.val);

        List<Integer> res = new ArrayList<>();
        // manual stack
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }
}
