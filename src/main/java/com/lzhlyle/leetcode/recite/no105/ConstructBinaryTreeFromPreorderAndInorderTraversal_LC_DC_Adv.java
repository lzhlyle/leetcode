package com.lzhlyle.leetcode.recite.no105;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_LC_DC_Adv {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode _build(int[] preorder, int pb, int pe, int[] inorder, int ib, int ie) {
        int len = ie - ib, ri = ib;
        if (len == 0) return null;
        for (int i = ib; i < ie; i++) {
            if (inorder[i] == preorder[pb]) {
                ri = i;
                break;
            }
        }

        int lCnt = ri - ib;
        TreeNode res = new TreeNode(preorder[pb]);
        res.left = _build(preorder, pb + 1, pb + lCnt + 1, inorder, ib, ri);
        res.right = _build(preorder, pb + lCnt + 1, pe, inorder, ri + 1, ie);
        return res;
    }
}
