package com.lzhlyle.leetcode.tomorrow.no1028;

import java.util.Stack;

public class RecoverATreeFromPreorderTraversal_Iteration {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            int level = 0;
            while (S.charAt(i) == '-') {
                ++level;
                ++i;
            }

            int val = 0;
            while (i < S.length() && Character.isDigit(S.charAt(i)))
                val = val * 10 + (S.charAt(i++) - '0');

            while (level != stack.size()) stack.pop();

            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) stack.peek().left = node;
                else stack.peek().right = node;
            }
            stack.push(node);
        }

        while (stack.size() > 1) stack.pop();
        return stack.peek();
    }
}
