package com.lzhlyle.leetcode.week.no1008;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return _build(preorder, 0, preorder.length - 1);
    }

    private TreeNode _build(int[] arr, int l, int r) {
        if (l > r) return null;

        TreeNode res = new TreeNode(arr[l]);
        if (l == r) return res;

        int i = l + 1;
        while (i <= r && arr[i] <= res.val) i++;

        res.left = _build(arr, l + 1, i - 1);
        res.right = _build(arr, i, r);
        return res;
    }
}
