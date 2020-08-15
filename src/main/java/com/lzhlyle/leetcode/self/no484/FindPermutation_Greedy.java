package com.lzhlyle.leetcode.self.no484;

public class FindPermutation_Greedy {
    // reverse Ds
    public int[] findPermutation(String s) {
        char[] arr = s.toCharArray();
        int[] res = new int[arr.length + 1];
        for (int i = 0; i < res.length; i++)
            res[i] = i + 1;

        int i = 0, d = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == 'D') d++;
            else if (d > 0) {
                _reverse(res, i - d, i);
                d = 0;
            }
        }
        if (d > 0) _reverse(res, i - d, i);

        return res;
    }

    private void _reverse(int[] arr, int l, int r) {
        while (l < r) {
            int swap = arr[l];
            arr[l++] = arr[r];
            arr[r--] = swap;
        }
    }
}
