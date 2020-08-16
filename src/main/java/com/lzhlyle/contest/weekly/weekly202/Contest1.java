package com.lzhlyle.contest.weekly.weekly202;

public class Contest1 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int v : arr) {
            if ((v & 1) == 1) cnt++;
            else {
                if (cnt >= 3) return true;
                else cnt = 0;
            }
        }
        return cnt >= 3;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
