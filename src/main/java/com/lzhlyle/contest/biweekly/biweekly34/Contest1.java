package com.lzhlyle.contest.biweekly.biweekly34;

public class Contest1 {
    public int diagonalSum(int[][] mat) {
        int sum = 0, i = 0, j = mat.length - 1;
        for (int[] row : mat) {
            if (i == j) sum += row[i];
            else sum += row[i] + row[j];
            i++;
            j--;
        }
        return sum;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
