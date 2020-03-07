package com.lzhlyle.contest.biweekly21;

public class Contest3_Adv {
    private int max = 0;

    public int longestZigZag(TreeNode root) {
        move(root);
        return max - 1;
    }

    // 0:left, 1:right
    private int[] move(TreeNode curr) {
        if (curr == null) return new int[2];
        int[] l = move(curr.left), r = move(curr.right), res = {l[1] + 1, r[0] + 1};
        max = Math.max(max, Math.max(res[0], res[1]));
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
