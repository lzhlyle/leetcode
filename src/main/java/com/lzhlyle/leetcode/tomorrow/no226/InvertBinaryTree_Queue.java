package com.lzhlyle.leetcode.tomorrow.no226;

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
            queue.add(curr.left = curr.right);
            queue.add(curr.right = swap);
        }
        return root;
    }
}
