package com.lzhlyle.leetcode.recite.no337;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii_Memo {
    private Map<TreeNode, Integer> mapFalse = new HashMap<>(), mapTrue = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int non = dfs(root.left, false) + dfs(root.right, false);
        int rob = dfs(root.left, true) + dfs(root.right, true) + root.val;
        return Math.max(non, rob);
    }

    private int dfs(TreeNode root, boolean parentRob) {
        if (root == null) return 0;

        int non;
        if (mapFalse.containsKey(root)) non = mapFalse.get(root);
        else {
            non = dfs(root.left, false) + dfs(root.right, false);
            mapFalse.put(root, non);
        }
        if (parentRob) return non;

        int rob;
        if (mapTrue.containsKey(root)) rob = mapTrue.get(root);
        else {
            rob = dfs(root.left, true) + dfs(root.right, true) + root.val;
            mapTrue.put(root, rob);
        }
        return Math.max(rob, non);
    }
}
