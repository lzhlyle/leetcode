package com.lzhlyle.leetcode.recite.no999;

public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int x = -1, y = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        if (x == -1) return 0;

        int cnt = 0;
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        for (int di = 0; di < 4; di++) {
            int i = x, j = y;
            while (true) {
                i += dx[di];
                j += dy[di];
                if (i < 0 || j < 0 || i >= 8 || j >= 8) break;
                if (board[i][j] == '.') continue;
                if (board[i][j] == 'p') cnt++;
                break;
            }
        }
        return cnt;
    }
}
