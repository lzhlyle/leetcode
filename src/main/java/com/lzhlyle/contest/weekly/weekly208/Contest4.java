package com.lzhlyle.contest.weekly.weekly208;

public class Contest4 {
    public int maximumRequests(int n, int[][] requests) {
        return bt(requests, 0, 0, new int[n]);
    }

    private int bt(int[][] req, int i, int cnt, int[] degree) {
        if (i == req.length) {
            for (int d : degree)
                if (d != 0) return 0;
            return cnt;
        }

        // 不跳过 req[i]
        int from = req[i][0], to = req[i][1];
        degree[from]--;
        degree[to]++;
        int notSkip = bt(req, i + 1, cnt + 1, degree);
        degree[from]++;
        degree[to]--;

        // 跳过 req[i]
        int skip = bt(req, i + 1, cnt, degree);

        return Math.max(notSkip, skip);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
