package com.lzhlyle.templates.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeOrderFromString {
    // 特殊占位，区分"未知"与"null"
    private final TreeNode nilNode = new TreeNode('0');

    class TreeNode {
        char value;
        TreeNode left;
        TreeNode right;

        TreeNode(char value) {
            this.value = value;
            this.left = nilNode;
            this.right = nilNode;
        }
    }

    public TreeNode getTreeWithPreOrder(String strPreOrder) {
        // base condition
        if (strPreOrder.startsWith("#")) return null;
        char[] chars = strPreOrder.toCharArray();
        Stack<TreeNode> unknownRightNodeStack = new Stack<>(); // 还未知右结点的
        TreeNode root = new TreeNode(chars[0]);
        TreeNode curr = root;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c != '#') {
                if (curr.left == nilNode) {
                    curr.left = new TreeNode(c);
                    unknownRightNodeStack.push(curr);
                    curr = curr.left;
                } else {
                    curr.right = new TreeNode(c);
                    curr = curr.right;
                }
            } else {
                if (curr.left == nilNode) curr.left = null;
                else curr.right = null;
            }
            if (curr.right != nilNode && !unknownRightNodeStack.isEmpty()) curr = unknownRightNodeStack.pop();
        }
        return root;
    }

    public TreeNode getTreeRecursionByPreOrder(String strPreOrder) {
        // base condition
        if (strPreOrder.startsWith("#")) return null;

        Queue<Character> queue = new LinkedList<>();
        for (char c : strPreOrder.toCharArray()) queue.add(c);

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(queue.remove());

        stack.push(root);
        this._appendLeft(queue, root, stack);

        return root;
    }

    private void _appendLeft(Queue<Character> queue, TreeNode curr, Stack<TreeNode> stack) {
        // terminator
        if (queue.isEmpty()) return;

        // process
        char c = queue.remove();
        if (curr.left == nilNode) {
            if (c == '#') {
                curr.left = null;
                this._appendRight(queue, stack); // drill down
            } else {
                curr.left = new TreeNode(c);

                stack.push(curr.left);
                this._appendLeft(queue, curr.left, stack); // drill down
            }
        }

        // reverse state
    }

    private void _appendRight(Queue<Character> queue, Stack<TreeNode> stack) {
        // terminator
        if (queue.isEmpty() || stack.isEmpty()) return;

        // process
        TreeNode curr = stack.pop();
        char c = queue.remove();
        if (curr.right == nilNode) {
            if (c == '#') {
                curr.right = null;
            } else {
                curr.right = new TreeNode(c);

                stack.push(curr.right);
                this._appendLeft(queue, curr.right, stack); // drill down
            }
        }

        // drill down
        this._appendRight(queue, stack);

        // reverse state
    }

    public static void main(String[] args) {
        String preOrder = "ABD#EF####CG#I##HJ###";

//        TreeNode root = new BinaryTreeOrderFromString().getTreeWithPreOrder(preOrder);
        TreeNode root = new BinaryTreeOrderFromString().getTreeRecursionByPreOrder(preOrder);

        System.out.println(root);
    }
}
