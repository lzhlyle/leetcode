package com.lzhlyle.leetcode.recite.no235;

public class LowestCommonAncestorOfABinarySearchTree_Iteration {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        int pv = p.val, qv = q.val;
        while ((curr.val - pv) * (curr.val - qv) < 0) {
            curr = curr.val > pv ? curr.left : curr.right;
        }
        return curr;
    }
}
