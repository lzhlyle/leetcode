package com.lzhlyle.leetcode.recite.no103;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            Queue<TreeNode> next = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            if ((level & 1) == 0) Collections.reverse(list);
            res.add(list);
            queue = next;
        }

        return res;
    }
}
