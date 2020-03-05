package com.lzhlyle.leetcode.recite.no105;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_LC_DC {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        if (len == 0) return null;
        int rootVal = preorder[0], ri = 0;
        for (int i = 0; i < len; i++) {
            if (inorder[i] == rootVal) {
                ri = i;
                break;
            }
        }

        int[] inorderLeft = new int[ri], inorderRight = new int[len - ri - 1];
        System.arraycopy(inorder, 0, inorderLeft, 0, ri);
        System.arraycopy(inorder, ri + 1, inorderRight, 0, len - ri - 1);

        int[] preorderLeft = new int[inorderLeft.length], preorderRight = new int[inorderRight.length];
        System.arraycopy(preorder, 1, preorderLeft, 0, ri);
        System.arraycopy(preorder, ri + 1, preorderRight, 0, len - ri - 1);

        TreeNode res = new TreeNode(rootVal);
        res.left = buildTree(preorderLeft, inorderLeft);
        res.right = buildTree(preorderRight, inorderRight);
        return res;
    }
}
