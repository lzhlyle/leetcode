package com.lzhlyle.contest.weekly.weekly180;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contest1 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < rows; r++) {
            int min = Integer.MAX_VALUE;
            for (int c = 0; c < cols; c++) {
                min = Math.min(min, matrix[r][c]);
            }
            set.add(min);
        }
        for (int c = 0; c < cols; c++) {
            int max = Integer.MIN_VALUE;
            for (int r = 0; r < rows; r++) {
                max = Math.max(max, matrix[r][c]);
            }
            if (set.contains(max)) res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {

        }
    }
}
