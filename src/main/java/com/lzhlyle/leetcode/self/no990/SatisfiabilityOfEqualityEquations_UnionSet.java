package com.lzhlyle.leetcode.self.no990;

import java.util.ArrayList;
import java.util.List;

public class SatisfiabilityOfEqualityEquations_UnionSet {
    public boolean equationsPossible(String[] equations) {
        List<char[]> notEquals = new ArrayList<>();
        UnionFind uf = new UnionFind(26);
        for (String str : equations) {
            char[] e = str.toCharArray();
            if (e[1] == '=') uf.union(e[0] - 'a', e[3] - 'a');
            else notEquals.add(e);
        }

        // 不相等的，应在不同队伍
        for (char[] e : notEquals)
            if (uf.find(e[0] - 'a') == uf.find(e[3] - 'a'))
                return false;
        return true;
    }

    class UnionFind {
        private int count;
        private int[] parent;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < 26; i++)
                parent[i] = i;
        }

        void union(int p, int q) {
            if (p == q) return;
            int rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        int find(int p) {
            int root = p;
            while (root != parent[root])
                root = parent[root];

            while (p != parent[p]) {
                int x = p;
                p = parent[p];
                parent[x] = root;
            }

            return root;
        }
    }
}
