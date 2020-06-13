package com.lzhlyle.contest.biweekly.biweekly28;

public class SubrectangleQueries {
    private int[][] data;
    private int m, n;

    public SubrectangleQueries(int[][] rectangle) {
        m = rectangle.length;
        n = rectangle[0].length;
        data = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                data[i][j] = rectangle[i][j];
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                data[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }
}
