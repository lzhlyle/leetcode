package com.lzhlyle.leetcode.recite.no1029;

public class TwoCityScheduling_Greedy_Adv {
    // O(n)
    public int twoCitySchedCost(int[][] costs) {
        int res = 0, n = costs.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            res += costs[i][0];
            arr[i] = costs[i][0] - costs[i][1];
        }

        quickSortSemi(arr, 0, n - 1);

        for (int i = n / 2; i < n; i++)
            res -= arr[i];
        return res;
    }

    // O(2n)
    // T(n) = T(n/2) + O(n)
    private void quickSortSemi(int[] arr, int l, int r) {
        if (l >= r) return;

        // O(n)
        int p = partition(arr, l, r), mid = arr.length / 2;
        if (p == mid || p == mid - 1) return;

        // ! T(n/2) !
        if (p > mid) quickSortSemi(arr, l, p - 1);
        else quickSortSemi(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int p = r, c = l;
        for (int i = l; i < r; i++)
            if (arr[i] < arr[r])
                swap(arr, i, c++);
        swap(arr, p, c);
        return c;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}
