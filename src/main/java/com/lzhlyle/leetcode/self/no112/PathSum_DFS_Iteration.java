package com.lzhlyle.leetcode.self.no112;

import java.util.Stack;

public class PathSum_DFS_Iteration {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<DfsNode> stack = new Stack<>();
        stack.push(new DfsNode(root, 0));
        while (!stack.isEmpty()) {
            DfsNode dfsNode = stack.pop();
            TreeNode node = dfsNode.node;
            int calc = dfsNode.curr + node.val;
            if (node.left == null && node.right == null)
                if (calc == sum) return true;
            if (node.left != null) stack.push(new DfsNode(node.left, calc));
            if (node.right != null) stack.push(new DfsNode(node.right, calc));
        }
        return false;
    }

    class DfsNode {
        TreeNode node;
        int curr;

        DfsNode(TreeNode node, int curr) {
            this.node = node;
            this.curr = curr;
        }
    }
}
