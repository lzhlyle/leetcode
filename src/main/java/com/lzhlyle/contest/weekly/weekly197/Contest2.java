package com.lzhlyle.contest.weekly.weekly197;

public class Contest2 {
    private static final int MOD = 1000000007;

    public int numSub(String s) {
        long cnt = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt++;
            else if (cnt > 0) {
                res += ((cnt + 1) * cnt / 2);
                if (res > MOD) res -= MOD;
                cnt = 0;
            }
        }
        if (cnt > 0) {
            res += ((cnt + 1) * cnt) / 2;
            if (res > MOD) res -= MOD;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
