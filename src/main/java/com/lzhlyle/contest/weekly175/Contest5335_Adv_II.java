package com.lzhlyle.contest.weekly175;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-students-taking-exam/
 * <p>
 * 5335. 参加考试的最大学生数
 */
public class Contest5335_Adv_II {
    private int max = 0;

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

        Map<Integer, Integer> currRowMap = new HashMap<>(); // (currRow, count)

//        int possible = size & (~(bad[ri] | lu | ru)); // 1 可坐，0 不可坐
//
//        for (int i = 0; i < bad.length; i++) {
//            int poss = possible;
//            int currRow = 0b0;
//            int cnt = 0;
//            while (poss != 0) {
//                cnt++;
//                int pos = (poss & (-poss));
//                poss &= poss - 1;
//                poss &= (~((pos << 1) | (pos >> 1)));
//                currRow |= pos;
//            }
//            currRowMap.put(currRow, cnt);
//        }

        for (Integer currRow : currRowMap.keySet()) {
            locateRow(size, bad, ri + 1, currRow << 1, currRow >> 1, currRowMap.get(currRow)); // 下一排;
        }
    }

    public static void main(String[] args) {
        // [[".",".","#",".","."],[".",".",".",".","#"],[".","#","#","#","."],[".","#","#","#","."]]
        {
            char[][] seats = {{'.', '.', '#', '.', '.'},
                    {'.', '.', '.', '.', '#'},
                    {'.', '#', '#', '#', '.'},
                    {'.', '#', '#', '#', '.'}};
            int res = new Contest5335_Adv_II().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 8);
        }

        // [[".",".",".",".","#",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],
        // [".",".",".",".",".",".","#","."],[".",".",".",".",".",".",".","."],[".",".","#",".",".",".",".","."],
        // [".",".",".",".",".",".",".","."],[".",".",".","#",".",".","#","."]]
        {
            char[][] seats = {{'.', '.', '.', '.', '#', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '#', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '#', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '#', '.', '.', '#', '.'}};
            int res = new Contest5335_Adv_II().maxStudents(seats);
            System.out.println(res);
        }

        // {{'.','#','#','.'},{'.','.','.','#'},{'.','.','.','.'},{'#','.','#','#'}}
        {
            char[][] seats = {{'.', '#', '#', '.'},
                    {'.', '.', '.', '#'},
                    {'.', '.', '.', '.'},
                    {'#', '.', '#', '#'}};
            int res = new Contest5335_Adv_II().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 5);
        }

        // {{'#','.','.'},{'.','#','.'}}
        {
            char[][] seats = {{'#', '.', '.'},
                    {'.', '#', '.'}};
            int res = new Contest5335_Adv_II().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 3);
        }

        {
            char[][] seats = {{'#', '.', '#', '#', '.', '#'},
                    {'.', '#', '#', '#', '#', '.'},
                    {'#', '.', '#', '#', '.', '#'}};
            int res = new Contest5335_Adv_II().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 4);
        }
        {
            char[][] seats = {{'.', '#'},
                    {'#', '#'},
                    {'#', '.'},
                    {'#', '#'},
                    {'.', '#'}};
            int res = new Contest5335_Adv_II().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 3);
        }
        {
            char[][] seats = {{'#', '.', '.', '.', '#'},
                    {'.', '#', '.', '#', '.'},
                    {'.', '.', '#', '.', '.'},
                    {'.', '#', '.', '#', '.'},
                    {'#', '.', '.', '.', '#'}};
            int res = new Contest5335_Adv_II().maxStudents(seats);
            System.out.println(res);
            System.out.println(res == 10);
        }
    }
}
