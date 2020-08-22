package com.lzhlyle.leetcode.self.no437;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii_Presum {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>(); // presum
        map.put(0, 1);
        return dfs(root, map, sum, 0);
    }

    private int dfs(TreeNode node, Map<Integer, Integer> map, int sum, int curr) {
        if (node == null) return 0;
        curr += node.val;
        int cnt = map.getOrDefault(curr - sum, 0);

        map.put(curr, map.getOrDefault(curr, 0) + 1);
        cnt += dfs(node.left, map, sum, curr);
        cnt += dfs(node.right, map, sum, curr);
        map.put(curr, map.getOrDefault(curr, 0) - 1); // bt: 向左的前缀和，不能算入向右的前缀和

        return cnt;
    }
}
