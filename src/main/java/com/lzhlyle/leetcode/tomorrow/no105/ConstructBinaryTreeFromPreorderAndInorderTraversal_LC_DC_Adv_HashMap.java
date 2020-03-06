package com.lzhlyle.leetcode.tomorrow.no105;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_LC_DC_Adv_HashMap {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length, inorderMap);
    }

    private TreeNode build(int[] preorder, int pbegin, int pend,
                           int[] inorder, int ibegin, int iend, Map<Integer, Integer> inorderMap) {
        if (pend == pbegin) return null;
        int rootVal = preorder[pbegin], inLeftCnt = inorderMap.get(rootVal) - ibegin;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, pbegin + 1, pbegin + 1 + inLeftCnt,
                inorder, ibegin, ibegin + inLeftCnt, inorderMap);
        root.right = build(preorder, pbegin + 1 + inLeftCnt, pend,
                inorder, ibegin + inLeftCnt + 1, iend, inorderMap);
        return root;
    }
}
