package com.lzhlyle.leetcode.self.no337;

public class HouseRobberIii_DP {
    public int rob(TreeNode root) {
        int[] res = _rob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] _rob(TreeNode root) {
        if (root == null) return new int[2];
        int[] res = new int[2], dpl = _rob(root.left), dpr = _rob(root.right); // 0:non, 1:rob
        res[0] = Math.max(dpl[0], dpl[1]) + Math.max(dpr[0], dpr[1]);
        res[1] = dpl[0] + dpr[0] + root.val;
        return res;
    }
}
