package com.lzhlyle.contest.biweekly.biweekly29;

public class Contest2 {
    public int kthFactor(int n, int k) {
        int cnt = 0, res = 1;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                res = i;
            }
            if (cnt == k) return res;
        }
        if (cnt < k) return -1;
        return res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
