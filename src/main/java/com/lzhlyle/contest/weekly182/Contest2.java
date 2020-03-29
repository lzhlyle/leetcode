package com.lzhlyle.contest.weekly182;

public class Contest2 {
    public int numTeams(int[] rating) {
        int n = rating.length, cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int k = i + 2; k < n; k++) {
                if (rating[i] == rating[k]) continue;
                if (rating[i] < rating[k]) {
                    for (int j = i + 1; j < k; j++) {
                        if (rating[i] < rating[j] && rating[j] < rating[k]) cnt++;
                    }
                } else {
                    // r[i] > r[k]
                    for (int j = i + 1; j < k; j++) {
                        if (rating[i] > rating[j] && rating[j] > rating[k]) cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
