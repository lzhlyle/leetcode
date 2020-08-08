package com.lzhlyle.leetcode.self.no99;

public class RecoverBinarySearchTree_Recursion {
    // O(n), O(h)
    private TreeNode prev, bad1, bad2;

    public void recoverTree(TreeNode root) {
        prev = bad1 = bad2 = null;
        dfs(root);
        int swap = bad1.val;
        bad1.val = bad2.val;
        bad2.val = swap;
    }

    private boolean dfs(TreeNode curr) {
        if (curr == null) return false;
        if (dfs(curr.left)) return true;
        if (prev != null && curr.val < prev.val) {
            bad2 = curr; // 当前这个有问题
            if (bad1 == null) bad1 = prev; // 首次遇到，前一个肯定有问题
            else return true; // 再次遇到，剪枝结束
        }
        prev = curr;
        return dfs(curr.right);
    }
}
