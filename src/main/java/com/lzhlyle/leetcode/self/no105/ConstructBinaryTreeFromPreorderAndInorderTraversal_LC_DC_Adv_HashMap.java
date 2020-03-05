package com.lzhlyle.leetcode.self.no105;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_LC_DC_Adv_HashMap {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return _build(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode _build(int[] preorder, int pbegin, int pend, int[] inorder, int ibegin, int iend, Map<Integer, Integer> map) {
        if (ibegin == iend) return null;
        int rootVal = preorder[pbegin], rootIndex = map.get(rootVal), leftCnt = rootIndex - ibegin;
        TreeNode res = new TreeNode(rootVal);
        res.left = _build(preorder, pbegin + 1, pbegin + 1 + leftCnt, inorder, ibegin, rootIndex, map);
        res.right = _build(preorder, pbegin + 1 + leftCnt, pend, inorder, rootIndex + 1, iend, map);
        return res;
    }
}
