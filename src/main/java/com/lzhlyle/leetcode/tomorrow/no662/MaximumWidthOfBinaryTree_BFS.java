package com.lzhlyle.leetcode.tomorrow.no662;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumWidthOfBinaryTree_BFS {
    // tle
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        TreeNode dummy = new TreeNode(-1);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            max = Math.max(max, deque.size());
            Deque<TreeNode> next = new LinkedList<>();
            while (!deque.isEmpty()) {
                TreeNode node = deque.remove();
                next.add(node.left == null ? dummy : node.left);
                next.add(node.right == null ? dummy : node.right);
            }

            // trim
            while (!next.isEmpty() && next.getLast() == dummy)
                next.removeLast();
            while (!next.isEmpty() && next.getFirst() == dummy)
                next.removeFirst();
            
            deque = next;
        }
        return max;
    }
}
