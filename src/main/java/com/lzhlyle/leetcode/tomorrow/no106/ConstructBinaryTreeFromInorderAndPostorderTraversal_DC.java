package com.lzhlyle.leetcode.tomorrow.no106;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_DC {
    // recursion
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>(); // (val, inorder's index)
        for (int i = 0; i < len; i++) map.put(inorder[i], i);
        return build(map, 0, len - 1, postorder, 0, len - 1);
    }

    private TreeNode build(Map<Integer, Integer> map, int il, int ir, int[] postorder, int pl, int pr) {
        if (il > ir) return null;
        TreeNode res = new TreeNode(postorder[pr]);
        int p = map.get(res.val), lCnt = p - il;
        res.left = build(map, il, p - 1, postorder, pl, pl + lCnt - 1);
        res.right = build(map, p + 1, ir, postorder, pl + lCnt, pr - 1);
        return res;
    }
}
