package com.lzhlyle.contest.weekly176;

public class Contest1_Adv {
    public int countNegatives(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            if (row[n - 1] >= 0) continue;
            if (row[0] < 0) {
                count += (m - i) * n;
                break;
            }
            int first = _binarySearch(row);
            count += n - first;
        }
        return count;
    }

    // 查找第一个小于 0 的数的索引
    private int _binarySearch(int[] arr) {
        int begin = 0, end = arr.length;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if (arr[mid] >= 0) begin = mid;
            else {
                if (arr[mid - 1] >= 0) return mid;
                end = mid - 1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        Contest1_Adv contest = new Contest1_Adv();
        {

        }
    }
}
