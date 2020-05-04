package com.lzhlyle.leetcode.self.no106;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_DC {
    // recursion
    private Map<Integer, Integer> map = new HashMap<>(); // (inorder val, inorder index))

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;
        return _build(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    private TreeNode _build(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        // look up ROOT NODE first
        TreeNode root = new TreeNode(postorder[pr]);
        int pivot = map.get(root.val); // root index in in-order array;
        int leftCnt = pivot - il;

        root.left = pivot == il ? null : _build(inorder, il, pivot - 1, postorder, pl, pl + leftCnt - 1);
        root.right = pivot == ir ? null : _build(inorder, pivot + 1, ir, postorder, pl + leftCnt, pr - 1);
        return root;
    }
}
