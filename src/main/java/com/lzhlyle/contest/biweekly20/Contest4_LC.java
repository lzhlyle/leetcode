package com.lzhlyle.contest.biweekly20;

public class Contest4_LC {
    public int countOrders(int n) {
        if (n == 1) return 1;
        long res = 6;
        for (int i = 2; i < n; i++) {
            res = res * (2 * i + 1 + ((2 * i + 1) * (2 * i)) / 2);
            res = res % (1000000007);
        }
        return (int) (res % (1000000007));
    }

    public static void main(String[] args) {
        Contest4_LC contest = new Contest4_LC();
        {
            int res = contest.countOrders(3);
            System.out.println(res);
        }
    }
}
