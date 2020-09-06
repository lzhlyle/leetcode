package com.lzhlyle.contest.weekly.weekly205;

public class Contest3 {
    public int minCost(String s, int[] cost) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n == 1) return 0;

        int res = 0;
        char last = '0';
        int lastIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == last) {
                if (cost[i] < cost[lastIndex]) {
                    res += cost[i];
                } else {
                    res += cost[lastIndex];
                    lastIndex = i;
                }
            } else lastIndex = i;
            last = arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
