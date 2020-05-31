package com.lzhlyle.leetcode.week.no199;

import java.util.*;

public class BinaryTreeRightSideView_BFS_Iterate {
    // bfs
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (queue.isEmpty()) res.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            queue = next;
        }
        return res;
    }
}
