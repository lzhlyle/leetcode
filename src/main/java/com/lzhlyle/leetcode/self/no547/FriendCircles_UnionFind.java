package com.lzhlyle.leetcode.self.no547;

public class FriendCircles_UnionFind {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }
        return unionFind.count;
    }
}
