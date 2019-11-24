package com.lzhlyle.contest.date20191106;

import java.util.*;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Test1_2 {
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

        // dfs
        Map<TreeNode, Integer> visited = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        visited.put(root, 1);

        int max = 1;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            max = Math.max(max, visited.get(node));

            if (node.left != null && !visited.containsKey(node.left)) {
                stack.push(node.left);
                visited.put(node.left, visited.get(node) + 1);
            }
            if (node.right != null && !visited.containsKey(node.right)) {
                stack.push(node.right);
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
