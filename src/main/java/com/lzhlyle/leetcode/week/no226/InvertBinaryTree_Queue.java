package com.lzhlyle.leetcode.week.no226;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_Queue {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>(Collections.singleton(root));
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) continue;
            TreeNode swap = node.left;
            queue.add(node.left = node.right);
            queue.add(node.right = swap);
        }
        return root;
    }
}
