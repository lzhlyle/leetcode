package com.lzhlyle.leetcode.week.no108;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = build(nums, l, mid - 1);
        res.right = build(nums, mid + 1, r);
        return res;
    }
}
