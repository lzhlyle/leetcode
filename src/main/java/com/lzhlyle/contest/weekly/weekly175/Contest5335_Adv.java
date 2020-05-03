package com.lzhlyle.contest.weekly.weekly175;

/**
 * https://leetcode-cn.com/problems/maximum-students-taking-exam/
 * <p>
 * 5335. 参加考试的最大学生数
 */
public class Contest5335_Adv {
    private int max = 0;

    // wrong
    public int maxStudents(char[][] seats) {
        int rows = seats.length, cols = seats[0].length;
        int[] bad = new int[rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (seats[r][c] == '#') bad[r] |= (1 << (cols - 1 - c));
            }
        }
        locateRow((1 << cols) - 1, bad, 0, 0b0, 0b0, 0);
        return max;
    }

    private void locateRow(int size, int[] bad, int ri, int lu, int ru, int count) {
        if (ri == bad.length) {
            max = Math.max(max, count);
            return;
        }

        int possible = size & (~(bad[ri] | lu | ru)); // 1 可坐，0 不可坐
        locateCol(size, bad, ri, count, possible, 0b0, true);
        locateCol(size, bad, ri, count, possible, 0b0, false);
    }

    private void locateCol(int size, int[] bad, int ri, int count, int possible, int positions, boolean isSeat) {
        if (possible == 0) {
            locateRow(size, bad, ri + 1, positions >> 1, positions << 1, count); // 下一排;
            return;
        }

        if (isSeat) {
            count++;
            positions |= (possible & (-possible));
            possible &= possible - 1;
            possible &= (~((positions << 1) | (positions >> 1)));
        } else {
            possible &= possible - 1;
        }
        locateCol(size, bad, ri, count, possible, positions, true);
        locateCol(size, bad, ri, count, possible, positions, false);
    }

    public static void main(String[] args) {
        // [[".",".",".",".","#",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],
        // [".",".",".",".",".",".","#","."],[".",".",".",".",".",".",".","."],[".",".","#",".",".",".",".","."],
        // [".",".",".",".",".",".",".","."],[".",".",".","#",".",".","#","."]]
        {
            char[][] seats = {{'.', '.', '.', '.', '#', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '#', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '#', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '#', '.', '.', '#', '.'}};
            int res = new Contest5335_Adv().maxStudents(seats);
            System.out.println(res);
        }

        // {{'.','#','#','.'},{'.','.','.','#'},{'.','.','.','.'},{'#','.','#','#'}}
        {
            char[][] seats = {{'.', '#', '#', '.'},
                    {'.', '.', '.', '#'},
                    {'.', '.', '.', '.'},
                    {'#', '.', '#', '#'}};
            int res = new Contest5335_Adv().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 5);
        }

        // {{'#','.','.'},{'.','#','.'}}
        {
            char[][] seats = {{'#', '.', '.'},
                    {'.', '#', '.'}};
            int res = new Contest5335_Adv().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 3);
        }

        {
            char[][] seats = {{'#', '.', '#', '#', '.', '#'},
                    {'.', '#', '#', '#', '#', '.'},
                    {'#', '.', '#', '#', '.', '#'}};
            int res = new Contest5335_Adv().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 4);
        }
        {
            char[][] seats = {{'.', '#'},
                    {'#', '#'},
                    {'#', '.'},
                    {'#', '#'},
                    {'.', '#'}};
            int res = new Contest5335_Adv().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 3);
        }
        {
            char[][] seats = {{'#', '.', '.', '.', '#'},
                    {'.', '#', '.', '#', '.'},
                    {'.', '.', '#', '.', '.'},
                    {'.', '#', '.', '#', '.'},
                    {'#', '.', '.', '.', '#'}};
            int res = new Contest5335_Adv().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 10);
        }
    }
}
