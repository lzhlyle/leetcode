package com.lzhlyle.leetcode.tomorrow.no1008;

import java.util.Stack;

public class ConstructBinarySearchTreeFromPreorderTraversal_Stack {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode res = new TreeNode(preorder[0]);
        stack.push(res);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (node.val < stack.peek().val) stack.peek().left = node;
            else {
                TreeNode curr = stack.peek();
                while (!stack.isEmpty() && node.val > stack.peek().val) // 与栈中未出来的比
                    curr = stack.pop();
                curr.right = node;
            }
            stack.push(node);
        }
        return res;
    }
}
