package com.lzhlyle.contest.weekly.weekly176;

public class Contest1 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int i : row) {
                if (i < 0) count++;
            }
        }
        return count;
    }

    // 查找第一个小于 0 的数的索引
    private int _binarySearch(int[] arr) {
        return -1;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
