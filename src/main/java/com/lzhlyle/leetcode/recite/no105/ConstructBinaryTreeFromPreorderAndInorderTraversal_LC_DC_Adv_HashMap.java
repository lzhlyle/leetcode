package com.lzhlyle.leetcode.recite.no105;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_LC_DC_Adv_HashMap {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return _build(preorder, 0, preorder.length, inorder, 0, inorder.length, inorderMap);
    }

    private TreeNode _build(int[] preorder, int pb, int pe, int[] inorder, int ib, int ie, Map<Integer, Integer> inorderMap) {
        if (ie == ib) return null;
        int ri = inorderMap.get(preorder[pb]), lCnt = ri - ib;
        TreeNode res = new TreeNode(preorder[pb]);
        res.left = _build(preorder, pb + 1, pb + lCnt + 1, inorder, ib, ri, inorderMap);
        res.right = _build(preorder, pb + lCnt + 1, pe, inorder, ri + 1, ie, inorderMap);
        return res;
    }
}
