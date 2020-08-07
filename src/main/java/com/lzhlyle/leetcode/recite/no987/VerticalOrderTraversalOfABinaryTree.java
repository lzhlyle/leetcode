package com.lzhlyle.leetcode.recite.no987;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Location> locations = new ArrayList<>();
        dfs(root, 0, 0, locations);
        Collections.sort(locations, (a, b) -> {
            if (a.x != b.x) return a.x - b.x;
            if (a.y != b.y) return a.y - b.y;
            return a.val - b.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int prev = locations.get(0).x;
        for (Location loc : locations) {
            if (loc.x != prev) {
                prev = loc.x;
                res.add(new ArrayList<>());
            }
            res.get(res.size() - 1).add(loc.val);
        }
        return res;
    }

    public void dfs(TreeNode node, int x, int y, List<Location> locations) {
        if (node == null) return;
        locations.add(new Location(x, y, node.val));
        dfs(node.left, x - 1, y + 1, locations);
        dfs(node.right, x + 1, y + 1, locations);
    }

    class Location {
        int x, y, val;

        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
