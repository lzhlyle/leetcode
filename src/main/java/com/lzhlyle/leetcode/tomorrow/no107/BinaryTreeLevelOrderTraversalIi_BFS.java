package com.lzhlyle.leetcode.tomorrow.no107;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi_BFS {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                row.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            res.add(row);
            queue = next;
        }
        Collections.reverse(res);
        return res;
    }
}
