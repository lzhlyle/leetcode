package com.lzhlyle.contest.weekly175;

import java.util.*;

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

        List<Integer> possibleIndexes = new ArrayList<>(); // [0,1,3,6,8]
        int possible = size & (~(bad[ri] | lu | ru)); // 1 可坐，0 不可坐
        for (int i = 0; i < bad.length; i++) {
            if (((possible >> i) & 1) == 1) possibleIndexes.add(i);
        }

        List<List<Integer>> res = new LinkedList<>();
        subIndex(possibleIndexes, 0, new LinkedList<>(), res);

        Map<Integer, Integer> currRowMap = new HashMap<>(); // (currRow, count)
        for (List<Integer> possibleIndexList : res) {
            int currPossible = possible, currRow = 0b0, cnt = 0;
            for (Integer possibleIndex : possibleIndexList) {
                if (((currPossible >> possibleIndex) & 1) == 0) continue;
                currRow |= (1 << possibleIndex);
                cnt++;
                currPossible &= (~(currRow | (currRow << 1) | (currRow >> 1)));
            }
            currRowMap.put(currRow, cnt);
        }

        for (Integer currRow : currRowMap.keySet()) {
            locateRow(size, bad, ri + 1, currRow << 1, currRow >> 1, currRowMap.get(currRow)); // 下一排;
        }
    }

    private void subIndex(List<Integer> possibleIndexes, int i, List<Integer> curr, List<List<Integer>> res) {
        if (i >= possibleIndexes.size()) {
            res.add(curr);
            return;
        }
        subIndex(possibleIndexes, i + 1, curr, res);
        curr.add(possibleIndexes.get(i));
        subIndex(possibleIndexes, i + 1, new LinkedList<>(curr), res);
    }

    private void _subArr(int[] arr, int i, List<Integer> curr) {
        if (i >= arr.length) {
            System.out.println(curr);
            return;
        }
        _subArr(arr, i + 1, new LinkedList<>(curr));
        curr.add(arr[i]);
        _subArr(arr, i + 1, new LinkedList<>(curr));
    }

    public static void main(String[] args) {
//        new Contest5335_Adv_II()._subArr(new int[]{1, 2, 3}, 0, new LinkedList<>());

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
