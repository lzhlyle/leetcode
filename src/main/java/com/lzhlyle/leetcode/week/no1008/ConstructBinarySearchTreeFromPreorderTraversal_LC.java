package com.lzhlyle.leetcode.week.no1008;

public class    ConstructBinarySearchTreeFromPreorderTraversal_LC {
    private int i; // 全局变量

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return _build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode _build(int[] arr, int bound) {
        if (i == arr.length || arr[i] > bound) return null;
        TreeNode res = new TreeNode(arr[i++]);
        res.left = _build(arr, res.val);
        res.right = _build(arr, bound);
        return res;
    }
}
