package com.lzhlyle.leetcode.self.no94;

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
        // stack, double while
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }
}
