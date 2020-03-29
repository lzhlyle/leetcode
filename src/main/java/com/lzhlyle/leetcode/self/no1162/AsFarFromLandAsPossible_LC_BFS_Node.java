package com.lzhlyle.leetcode.self.no1162;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible_LC_BFS_Node {
    // bfs
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) queue.add(new Node(i, j));
            }
        }
        if (queue.isEmpty() || queue.size() == n * n) return -1;

        int far = -1;
        while (!queue.isEmpty()) {
            far++;
            Queue<Node> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                for (int di = 0; di < 4; di++) {
                    int x = node.x + dx[di], y = node.y + dy[di];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        next.add(new Node(x, y));
                        grid[x][y] = 2;
                    }
                }
            }
            queue = next;
        }
        return far;
    }

    private class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
