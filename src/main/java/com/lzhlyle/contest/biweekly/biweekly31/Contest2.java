package com.lzhlyle.contest.biweekly.biweekly31;

public class Contest2 {
    private static final int MOD = 1000000007;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        int cnt = 0, odd = 0, even = 1;
        for (int p : pre) {
            if ((p & 1) == 1) {
                cnt += even;
                odd++;
            } else {
                cnt += odd;
                even++;
            }
            if (cnt > MOD) cnt -= MOD;
        }
        return cnt % MOD;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
