package com.lzhlyle.leetcode.recite.no199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeRightSideView_DFS_Iterate {
    // dfs
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(new MyTreeNode(0, root));
        while (!stack.isEmpty()) {
            MyTreeNode myNode = stack.pop();
            TreeNode node = myNode.node;
            if (res.size() == myNode.level) res.add(node.val);
            else res.set(myNode.level, node.val);
            if (node.right != null) stack.push(new MyTreeNode(myNode.level + 1, node.right));
            if (node.left != null) stack.push(new MyTreeNode(myNode.level + 1, node.left));
        }
        return res;
    }

    class MyTreeNode {
        TreeNode node;
        int level;

        MyTreeNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
}
