package com.lzhlyle.contest.biweekly.biweekly34;

public class Contest2 {
    private static int MOD = 1000000007;

    public int numWays(String s) {
        char[] arr = s.toCharArray();
        int one = 0;
        for (char c : arr)
            if (c == '1') one++;
        if (one % 3 != 0) return 0;

        int n = arr.length;
        if (one == 0) return (int) (cn2(n - 1) % MOD);

        int eachOne = one / 3, currOne = 0;
        int[][] memo = new int[3][2];
        for (int i = 0, mi = 0; i < n; i++) {
            if (arr[i] == '1') {
                currOne++;
                if (currOne % eachOne == 1) memo[mi][0] = i;
                if (currOne % eachOne == 0) {
                    if (eachOne == 1) memo[mi][0] = i;
                    memo[mi++][1] = i;
                }
            }
        }
        return (int) ((long) (memo[2][0] - memo[1][1]) * (long) (memo[1][0] - memo[0][1]) % MOD);
    }

    private long cn2(int n) {
        return (long) n * (long) (n - 1) / 2;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            String str = "10101";
            int res = contest.numWays(str);
            System.out.println(res);
        }
    }
}
