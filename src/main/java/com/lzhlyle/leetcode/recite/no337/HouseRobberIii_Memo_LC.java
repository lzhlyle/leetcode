package com.lzhlyle.leetcode.recite.no337;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii_Memo_LC {
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;

        if (map.containsKey(root)) return map.get(root);

        int sum = root.val;
        if (root.left != null) sum += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) sum += rob(root.right.left) + rob(root.right.right);

        int res = Math.max(sum, rob(root.left) + rob(root.right));
        map.put(root, res);
        return res;
    }
}
