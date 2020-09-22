package com.lzhlyle.leetcode.self.no968;

public class BinaryTreeCameras {
    public int minCameraCover(TreeNode root) {
        int[] arr = dfs(root);
        return Math.min(arr[1], arr[2]);
    }

    // int[3]: {未被监控-未安装, 已被监控-未安装, 已被监控-已安装}
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0, 1};
        int[] l = dfs(node.left), r = dfs(node.right);
        int[] res = new int[3];
        res[0] = l[1] + r[1];
        res[1] = Math.min(l[2] + Math.min(r[1], r[2]),
                r[2] + Math.min(l[1], l[2]));
        res[2] = Math.min(l[0], Math.min(l[1], l[2])) +
                Math.min(r[0], Math.min(r[1], r[2])) + 1;
        return res;
    }
}
