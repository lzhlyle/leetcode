package com.lzhlyle.contest.weekly175;

/**
 * https://leetcode-cn.com/problems/maximum-students-taking-exam/
 * <p>
 * 5335. 参加考试的最大学生数
 */
public class Contest5335 {
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
        locate((1 << cols) - 1, bad, 0, 0b0, 0b0, 0);
        return max;
    }

    private void locate(int size, int[] bad, int ri, int lu, int ru, int count) {
        if (ri == bad.length) {
            max = Math.max(max, count);
            return;
        }

        // 此排不再坐，直接下一排
        locate(size, bad, ri + 1, 0b0, 0b0, count);

        int possible = size & (~(bad[ri] | lu | ru)); // 1 可坐，0 不可坐
        int positions = 0b0; // 1 已坐，0 未坐

        while (possible != 0) {
            // 坐最右开始
            positions |= (possible & (-possible));
            possible &= possible - 1;
            possible &= (~((positions << 1) | (positions >> 1)));
            count++;
            locate(size, bad, ri + 1, positions >> 1, positions << 1, count); // 下一排
        }
    }

    public static void main(String[] args) {
        // {{'.','#','#','.'},{'.','.','.','#'},{'.','.','.','.'},{'#','.','#','#'}}
        {
            char[][] seats = {{'.', '#', '#', '.'},
                    {'.', '.', '.', '#'},
                    {'.', '.', '.', '.'},
                    {'#', '.', '#', '#'}};
            int res = new Contest5335().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 5);
        }

        // {{'#','.','.'},{'.','#','.'}}
        {
            char[][] seats = {{'#', '.', '.'},
                    {'.', '#', '.'}};
            int res = new Contest5335().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 3);
        }

        {
            char[][] seats = {{'#', '.', '#', '#', '.', '#'},
                    {'.', '#', '#', '#', '#', '.'},
                    {'#', '.', '#', '#', '.', '#'}};
            int res = new Contest5335().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 4);
        }
        {
            char[][] seats = {{'.', '#'},
                    {'#', '#'},
                    {'#', '.'},
                    {'#', '#'},
                    {'.', '#'}};
            int res = new Contest5335().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 3);
        }
        {
            char[][] seats = {{'#', '.', '.', '.', '#'},
                    {'.', '#', '.', '#', '.'},
                    {'.', '.', '#', '.', '.'},
                    {'.', '#', '.', '#', '.'},
                    {'#', '.', '.', '.', '#'}};
            int res = new Contest5335().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 10);
        }
    }
}
