package com.lzhlyle.contest.weekly.weekly206;

import java.util.ArrayList;
import java.util.List;

public class Contest1 {
    public int numSpecial(int[][] mat) {
        List<Integer> cols = new ArrayList<>();
        for (int[] row : mat) {
            int cnt = 0, colIndex = -1;
            for (int j = 0; j < mat[0].length && cnt <= 1; j++) {
                if (row[j] == 1) {
                    cnt++;
                    colIndex = j;
                }
            }
            if (cnt == 1) cols.add(colIndex);
        }

        int res = 0;
        for (int j : cols) {
            int cnt = 0;
            for (int[] row : mat) {
                if (row[j] == 1) cnt++;
            }
            if (cnt == 1) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
