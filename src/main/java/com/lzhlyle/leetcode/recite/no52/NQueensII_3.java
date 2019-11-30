package com.lzhlyle.leetcode.recite.no52;

public class NQueensII_3 {
    private int size; // 可填皇后的位置 queens, 0b1111
    private int count; // 多少种摆法

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1; // 所有情况数，用于取pos的边界
        solve(0, 0, 0);
        return count;
    }

    // ld 撇, rd 捺
    private void solve(int row, int ld, int rd) {
        // terminator
        if (row == size) {
            count++;
            return;
        }

        // 当前层能放皇后的所有的位置
        int pos = size & (~(row | ld | rd)); // 0b1111;
        while (pos != 0) { // 有能放的
            int p = pos & (-pos); // 取最低位的1
            pos &= pos - 1; // 放上皇后

            // recursion
            solve(row | p, // 下方格子
                    (ld | p) << 1, // 左下格子
                    (rd | p) >> 1); // 右下格子
        }
    }

    public static void main(String[] args) {
        int cnt = new NQueensII_3().totalNQueens(4);
        System.out.println(cnt);
    }
}
