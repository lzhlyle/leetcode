package com.lzhlyle.contest.biweekly21;

public class Contest3 {
    // wrong
    public int longestZigZag(TreeNode root) {
        int[] res = move(root);
        return Math.max(res[0], res[1]);
    }

    private int[] move(TreeNode curr) {
        if (curr == null) return new int[2];
        int[] res = new int[2], l = move(curr.left), r = move(curr.right);
        res[0] = Math.max(longestZigZag(curr.left), curr.left == null ? 0 : l[1] + 1);
        res[1] = Math.max(curr.right == null ? 0 : r[0] + 1, longestZigZag(curr.right));
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
        }
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
