package com.lzhlyle.leetcode.week.no547;

public class FriendCircles_UnionFind {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }
        return unionFind.count;
    }
}
