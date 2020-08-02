package com.lzhlyle.contest.weekly.weekly200;

public class Contest3 {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--)
                row[i]++;

        int res = 0;
        for (int i = 0; i < n; i++) {
            int need = n - i - 1;
            // look for first need
            if (row[i] >= need) continue;
            boolean has = false;
            for (int j = i + 1; j < n; j++) {
                if (row[j] >= need) {
                    has = true;
                    res += j - i;
                    int val = row[j];
                    for (int k = j; k > i; k--) {
                        row[k] = row[k - 1];
                    }
                    row[i] = val;
                    break;
                }
            }
            if (!has) return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
