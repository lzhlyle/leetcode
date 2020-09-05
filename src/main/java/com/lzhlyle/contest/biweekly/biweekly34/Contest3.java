package com.lzhlyle.contest.biweekly.biweekly34;

public class Contest3 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, l, r, min;

        // 找 arr[l + 1]
        for (l = 0; l + 1 < n; l++)
            if (arr[l + 1] < arr[l]) break;
        if (l + 1 == n) return 0;

        // 找 arr[r - 1]
        for (r = n - 1; r >= 0; r--)
            if (arr[r - 1] > arr[r]) break;

        // 此时 [0, l] 与 [r, n - 1] 都递增
        min = Math.min(n - 1 - l, r); // 删前，删后

        // 删中间
        for (int i = 0, j = r; i <= l; i++) {
            while (j < n && arr[j] < arr[i]) j++;
            if (j == n) break;

            // 此时 arr[i] == arr[j]
            min = Math.min(min, j - i - 1); // 删中间
        }

        return min;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
