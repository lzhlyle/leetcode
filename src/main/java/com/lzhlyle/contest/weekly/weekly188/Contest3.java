package com.lzhlyle.contest.weekly.weekly188;

import java.util.*;

public class Contest3 {
    private int time;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        time = 0;
        Map<Integer, TreeNode> map = new HashMap<>(); // (val, node)
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (!map.containsKey(from)) map.put(from, new TreeNode(from));
            if (!map.containsKey(to)) map.put(to, new TreeNode(to));
            map.get(from).children.add(map.get(to));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) set.add(i);
        }

        TreeNode root = map.get(0);
        find(1, root, set);
        return time;
    }

    private int find(int level, TreeNode curr, Set<Integer> set) {
        if (curr == null) return 0;

        // 找左、找右
        boolean found = false;
        for (TreeNode child : curr.children) {
            int c = find(level + 1, child, set);
            if (c > 0) {
                time += 2 * (c - level);
                found = true;
            }
        }

        if (found) return level;
        return set.contains(curr.val) ? level : 0;
    }

    class TreeNode {
        int val;
        List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
