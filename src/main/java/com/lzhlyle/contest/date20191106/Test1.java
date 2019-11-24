package com.lzhlyle.contest.date20191106;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Test1 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int maxDepth(TreeNode root) {
        // base condition
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        // bfs O(n)
        Map<TreeNode, Integer> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        visited.put(root, 1);

        int max = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            max = Math.max(max, visited.get(node));

            if (node.left != null && !visited.containsKey(node.left)) {
                queue.add(node.left);
                visited.put(node.left, visited.get(node) + 1);
            }
            if (node.right != null && !visited.containsKey(node.right)) {
                queue.add(node.right);
                visited.put(node.right, visited.get(node) + 1);
            }
        }

        return max;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
