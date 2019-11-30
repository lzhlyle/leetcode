package com.lzhlyle.leetcode.recite.no52;

public class NQueensII_3_1 {
    private int boardSize; // 棋盘大小，正方形，长=宽=borderSize
    private int count;

    public int totalNQueens(int n) {
        boardSize = (1 << n) - 1; // n个1
        count = 0;
        this._locate(0, 0, 0);
        return count;
    }

    /**
     * 开始放皇后
     *
     * @param row       已占用的列(所有皇后正下方的格子并集) -- 每一行中，已占用的列
     * @param leftDown  已占用的撇(所有皇后左下方的格子并集)
     * @param rightDown 已占用的捺(所有皇后向右下方的格子并集)
     */
    private void _locate(int row, int leftDown, int rightDown) {
        // terminator
        if (row == boardSize) {
            // 已放完，都没出现阻碍，解法+1
            count++;
            return;
        }
        // process
        // 可能的格子 = 棋盘大小 交 (~(已占用的并集))
        int possibles = boardSize & (~(row | leftDown | rightDown));
        while (possibles != 0) {
            // 试着放 = 所有可能的格子中最低位的
            int position = possibles & (-possibles); // get the lowest 1
            // 新可能的格子 = 原可能的格子 - 试着放的    pos -= p;
            // 新可能的格子 = 原可能的格子 - 最低位的    pos *= pos - 1;
            possibles &= possibles - 1; // remove position in possibles

            // drill down
            this._locate(row | position, // 并入所有皇后正下方
                    (leftDown | position) << 1, // 并入所有皇后左下方
                    (rightDown | position) >> 1); // 并入所有皇后右下方

            // reverse state
            // 位运算未改变上一层的 row, leftDown, rightDown，天生无需reverse
        }
    }
}
