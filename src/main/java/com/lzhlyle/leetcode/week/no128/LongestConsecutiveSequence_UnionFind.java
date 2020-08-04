package com.lzhlyle.leetcode.week.no128;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_UnionFind {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        UnionFind uf = new UnionFind(nums);
        for (int v : nums)
            uf.union(v, v + 1);

        int max = 1;
        for (int v : nums)
            max = Math.max(max, uf.find(v) - v + 1);
        return max;
    }

    class UnionFind {
        private int count;
        private Map<Integer, Integer> parent; // (left, right)

        UnionFind(int[] arr) {
            count = arr.length;
            parent = new HashMap<>();
            for (int v : arr)
                parent.put(v, v);
        }

        void union(int p, int q) {
            Integer rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) return;
            if (rootP == null || rootQ == null) return;

            parent.put(rootP, rootQ);
            count--;
        }

        Integer find(int p) {
            if (!parent.containsKey(p))
                return null;

            int root = p;
            while (root != parent.get(root))
                root = parent.get(root);

            while (p != parent.get(p)) {
                int curr = p;
                p = parent.get(p);
                parent.put(curr, root);
            }

            return root;
        }
    }
}
