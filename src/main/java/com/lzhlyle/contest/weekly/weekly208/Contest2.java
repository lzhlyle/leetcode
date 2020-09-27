package com.lzhlyle.contest.weekly.weekly208;

public class Contest2 {
    public int minOperationsMaxProfit(int[] arr, int b, int r) {
        int max = 0, total = 0; // 利润
        int i = 0, res = 0; // 次数
        int curr = 0; // 等待人数
        for (int cnt : arr) {
            curr += cnt;

            int board = Math.min(4, curr);
            curr -= board;

            total += board * b - r;
            i++;

            if (total > max) {
                max = total;
                res = i;
            }
        }

        while (curr > 0) {
            int board = Math.min(4, curr);
            curr -= board;

            total += board * b - r;
            i++;

            if (total > max) {
                max = total;
                res = i;
            }
        }
        return max == 0 ? -1 : res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
