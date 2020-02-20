package com.lzhlyle.leetcode.recite.no547;

public class FriendCircles_UnionFind {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (M[r][c] == 1) unionFind.union(r, c);
            }
        }
        return unionFind.count;
    }
}
