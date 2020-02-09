package com.lzhlyle.contest.weekly175;

/**
 * https://leetcode-cn.com/problems/maximum-students-taking-exam/
 *
 * 5335. 参加考试的最大学生数
 */
public class Contest4 {
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
        locate((1 << cols) - 1, bad, 0, 0b0, 0b0, 0, 0b0);
        return max;
    }

    private void locate(int size, int[] bad, int ri, int lu, int ru, int count, int r) {
        if (ri == bad.length) {
            max = Math.max(max, count);
            return;
        }

        int possible = size & (~(bad[ri] | lu | ru | r)); // 1 可坐，0 不可坐
        int positions = r; // 1 已坐，0 未坐

        // 此排不再坐，直接下一排
        locate(size, bad, ri + 1, positions >> 1, positions << 1, count, 0b0); // 下一排

        while (possible != 0) {
            int tmp = positions | (possible & (-possible)); // 最右的位置不坐
            locate(size, bad, ri, lu, ru, count, tmp);

            positions = tmp; // 坐最右开始
            possible &= possible - 1;
            possible &= (~((positions << 1) | (positions >> 1)));
            count++;
            locate(size, bad, ri + 1, positions >> 1, positions << 1, count, 0b0); // 下一排
        }
    }

    public static void main(String[] args) {
        // {{'.','#','#','.'},{'.','.','.','#'},{'.','.','.','.'},{'#','.','#','#'}}
        {
            char[][] seats = {{'.', '#', '#', '.'},
                    {'.', '.', '.', '#'},
                    {'.', '.', '.', '.'},
                    {'#', '.', '#', '#'}};
            int res = new Contest4().maxStudents(seats);
            System.out.println(res);
            assert res == 5;
        }

        // {{'#','.','.'},{'.','#','.'}}
        {
            char[][] seats = {{'#', '.', '.'},
                    {'.', '#', '.'}};
            int res = new Contest4().maxStudents(seats);
            System.out.println(res);
            assert res == 3;
        }

        {
            char[][] seats = {{'#', '.', '#', '#', '.', '#'},
                    {'.', '#', '#', '#', '#', '.'},
                    {'#', '.', '#', '#', '.', '#'}};
            int res = new Contest4().maxStudents(seats);
            System.out.println(res);
            assert res == 4;
        }
        {
            char[][] seats = {{'.', '#'},
                    {'#', '#'},
                    {'#', '.'},
                    {'#', '#'},
                    {'.', '#'}};
            int res = new Contest4().maxStudents(seats);
            System.out.println(res);
            assert res == 3;
        }
        {
            char[][] seats = {{'#', '.', '.', '.', '#'},
                    {'.', '#', '.', '#', '.'},
                    {'.', '.', '#', '.', '.'},
                    {'.', '#', '.', '#', '.'},
                    {'#', '.', '.', '.', '#'}};
            int res = new Contest4().maxStudents(seats);
            System.out.println(res);
            assert res == 10;
        }
    }
}
