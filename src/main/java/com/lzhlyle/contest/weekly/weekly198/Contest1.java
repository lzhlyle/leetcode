package com.lzhlyle.contest.weekly.weekly198;

public class Contest1 {
    public int numWaterBottles(int b, int e) {
        int cnt = 0, empty = 0;
        while (b > 0) {
            cnt++;
            b--;
            empty++;
            if (empty == e) {
                empty = 0;
                b++;
            }
        }
        if (empty == e) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
