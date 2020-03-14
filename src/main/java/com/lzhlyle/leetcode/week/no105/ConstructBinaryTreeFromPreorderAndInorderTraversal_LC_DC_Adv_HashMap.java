package com.lzhlyle.leetcode.week.no105;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_LC_DC_Adv_HashMap {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return _build(preorder, 0, preorder.length, inorder, 0, inorder.length, inorderMap);
    }

    private TreeNode _build(int[] preorder, int pbegin, int pend,
                            int[] inorder, int ibegin, int iend,
                            Map<Integer, Integer> inorderMap) {
        if (ibegin == iend) return null;
        int val = preorder[pbegin], rootInorder = inorderMap.get(val), leftCnt = rootInorder - ibegin;
        TreeNode res = new TreeNode(val);
        res.left = _build(preorder, pbegin + 1, pbegin + 1 + leftCnt,
                inorder, ibegin, rootInorder, inorderMap);
        res.right = _build(preorder, pbegin + 1 + leftCnt, pend,
                inorder, rootInorder + 1, iend, inorderMap);
        return res;
    }
}
