package com.lzhlyle.leetcode.recite.noLCP13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class XunBao {
    private int m, n;
    private char[][] mat;
    private int[] s, t;
    private int[][] marr, oarr;
    private int mi, oi;

    private int[][] memoToO;
    private int[][] memoToM;

    public int minimalSteps(String[] maze) {
        m = maze.length;
        n = maze[0].length();
        mat = new char[m][n];
        for (int i = 0; i < m; i++)
            mat[i] = maze[i].toCharArray();

        marr = new int[16][2];
        oarr = new int[40][2];
        mi = 0;
        oi = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'M') marr[mi++] = new int[]{i, j};
                else if (mat[i][j] == 'O') oarr[oi++] = new int[]{i, j};
                else if (mat[i][j] == 'S') s = new int[]{i, j};
                else if (mat[i][j] == 'T') t = new int[]{i, j};
            }
        }
        if (s == null || t == null) return -1;
        if (mi == 0) return dis(s, t);
        memoToO = new int[mi + 1][oi];
        memoToM = new int[mi + 1][mi];


        // dp[i][j]，选后局面 i，选择 mo[j]
        int[][] dp = new int[1 << mi][mi];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        // S-O-M
        for (int j = 0; j < mi; j++)
            dp[1 << j][j] = disToOM(mi, j);

        // M-O-M
        for (int pre = 1; pre < (1 << mi); pre++) { // 选前局面 pre
            for (int j = 0; j < mi; j++) { // 选择 mo[j]
                if (((pre >> j) & 1) == 1) continue; // 已选过 mo[j]
                int min = Integer.MAX_VALUE;
                for (int last = 0; last < mi; last++) { // 枚举上次可能的选择
                    if (last == j && ((pre >> last) & 1) == 0) continue; // 上次没选 mo[last]
                    if (dp[pre][last] == -1) continue; // 无法到达
                    int disToOM = disToOM(last, j);
                    if (disToOM == -1) continue; // 无法到达
                    int total = dp[pre][last] + disToOM;
                    min = Math.min(min, total);
                }
                int next = pre | (1 << j); // 选后局面
                dp[next][j] = min == Integer.MAX_VALUE ? -1 : min;
            }
        }

        // M-T
        int res = Integer.MAX_VALUE;
        for (int last = 0, i = (1 << mi) - 1; last < mi; last++) {
            int d = dis(marr[last], t);
            if (dp[i][last] == -1 || d == -1) continue;
            res = Math.min(res, dp[i][last] + d);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int disToOM(int ma, int mb) {
        if (memoToM[ma][mb] != 0) return memoToM[ma][mb];
        int[] from = ma == mi ? s : marr[ma];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < oi; i++) {
            int a = memoToO[ma][i] != 0 ?
                    memoToO[ma][i] : (memoToO[ma][i] = dis(from, oarr[i]));
            int b = memoToO[mb][i] != 0 ?
                    memoToO[mb][i] : (memoToO[mb][i] = dis(oarr[i], marr[mb]));
            if (a > 0 && b > 0) res = Math.min(res, a + b);
        }
        return memoToM[ma][mb] = (res == Integer.MAX_VALUE ? -1 : res);
    }

    // directions
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    // bfs
    private int dis(int[] from, int[] to) {
        if (from[0] == to[0] && from[1] == to[1]) return 0;

        int fx = from[0], fy = from[1], tx = to[0], ty = to[1];

        int res = Integer.MAX_VALUE;

        // model: {i, j, cnt}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{fx, fy, 0});

        boolean[][] visited = new boolean[m][n];
        visited[fx][fy] = true;

        while (!queue.isEmpty()) {
            int[] f = queue.remove(); // model: {i, j, cnt}
            for (int di = 0; di < 4; di++) {
                int x = f[0] + dx[di], y = f[1] + dy[di];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (x == tx && y == ty)
                        res = Math.min(res, f[2] + 1); // f.cnt
                    else if (visited[x][y]) continue;
                    else if (mat[x][y] != '#') {
                        queue.add(new int[]{x, y, f[2] + 1});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res; // cannot reach
    }
}
