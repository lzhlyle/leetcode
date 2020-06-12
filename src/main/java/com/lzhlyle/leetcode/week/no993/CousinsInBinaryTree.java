package com.lzhlyle.leetcode.week.no993;

import java.util.HashSet;
import java.util.Set;

public class CousinsInBinaryTree {
    private Set<TreeNode> set; // parents

    public boolean isCousins(TreeNode root, int x, int y) {
        set = new HashSet<>();
        int xd = depth(root, null, x), yd = depth(root, null, y);
        return set.size() == 2 && xd > 1 && xd == yd;
    }

    private int depth(TreeNode curr, TreeNode parent, int target) {
        if (curr == null) return -1;
        if (curr.val == target) {
            set.add(parent);
            return 0;
        }

        int l = depth(curr.left, curr, target);
        if (l > -1) return l + 1;

        int r = depth(curr.right, curr, target);
        if (r > -1) return r + 1;

        return -1;
    }
}
