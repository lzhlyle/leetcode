package com.lzhlyle.leetcode.self.no226;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_Queue {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>(Collections.singleton(root));
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr == null) continue;
            TreeNode swap = curr.left;
            curr.left = curr.right;
            curr.right = swap;
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return root;
    }
}
