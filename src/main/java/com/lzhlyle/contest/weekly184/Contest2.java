package com.lzhlyle.contest.weekly184;

import java.util.Arrays;

public class Contest2 {
    public int[] processQueries(int[] queries, int m) {
        int len = queries.length;
        int[] res = new int[len];

        int[] P = new int[m];
        for (int i = 0; i < m; i++) P[i] = i + 1;

        int ri = 0;
        for (int num : queries) {
            int i = search(P, ri, num);
            res[ri++] = i;
            System.arraycopy(P, 0, P, 1, i);
            P[0] = num;
        }
        return res;
    }

    private int search(int[] arr, int l, int num) {
        int i = Arrays.binarySearch(arr, l, arr.length, num);
        if (i > -1) return i;

        for (i = 0; i < l; i++) {
            if (arr[i] == num) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int[] q = {3, 1, 2, 1};
            int m = 5;
            int[] res = contest.processQueries(q, m);
            System.out.println(Arrays.toString(res));
        }
    }
}
