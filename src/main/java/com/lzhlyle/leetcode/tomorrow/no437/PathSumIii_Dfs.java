package com.lzhlyle.leetcode.tomorrow.no437;

public class PathSumIii_Dfs {
    public int pathSum(TreeNode root, int sum) {
        return dfs(root, sum, new int[0]);
    }

    private int dfs(TreeNode node, int sum, int[] arr) {
        if (node == null) return 0;
        int cnt = 0;
        int[] next = new int[arr.length + 1];
        int i = 0;
        for (int v : arr)
            if ((next[i++] = v + node.val) == sum) cnt++;
        if ((next[i] = node.val) == sum) cnt++;
        cnt += dfs(node.left, sum, next);
        cnt += dfs(node.right, sum, next);
        return cnt;
    }
}
