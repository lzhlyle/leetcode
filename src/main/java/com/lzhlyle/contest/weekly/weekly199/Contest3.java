package com.lzhlyle.contest.weekly.weekly199;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Contest3 {
    private int cnt;

    public int countPairs(TreeNode root, int dis) {
        if (root == null) return 0;
        cnt = 0;
        dfs(0, root, dis);
        return cnt;
    }

    // (level, cnt)
    private Map<Integer, Integer> dfs(int level, TreeNode node, int dis) {
        if (node == null) return Collections.emptyMap();

        if (node.left == null && node.right == null) {
            Map<Integer, Integer> res = new HashMap<>();
            res.put(level, 1);
            return res;
        }

        Map<Integer, Integer> l = dfs(level + 1, node.left, dis),
                r = dfs(level + 1, node.right, dis);

        for (int ll : l.keySet()) {
            int lcnt = l.get(ll);
            for (int rl : r.keySet()) {
                int rcnt = r.get(rl);
                if (ll - level + rl - level <= dis) { // ! 需 -level
                    cnt += lcnt * rcnt;
                }
            }
        }

        Map<Integer, Integer> res = new HashMap<>();
        res.putAll(l);
        for (int rl : r.keySet()) {
            res.put(rl, res.getOrDefault(rl, 0) + r.get(rl));
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
