package com.lzhlyle.contest.season.spring2020.team;

public class Contest1 {
    // O(n)
    public int expectNumber(int[] scores) {
        int[] freq = new int[1000001];
        for (int score : scores) freq[score]++;

        int cnt = 0;
        for (int f : freq) {
            if (f > 0) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            int[] arr = {1, 1};
            int res = contest.expectNumber(arr);
            System.out.println(res);
        }
    }
}
