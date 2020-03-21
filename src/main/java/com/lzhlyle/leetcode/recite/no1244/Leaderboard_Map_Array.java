package com.lzhlyle.leetcode.recite.no1244;

import java.util.HashMap;
import java.util.Map;

public class Leaderboard_Map_Array {
    Map<Integer, Integer> players; // user, score
    int[] freq;

    public Leaderboard_Map_Array() {
        players = new HashMap<>();
        freq = new int[100 * 1000];
    }

    public void addScore(int playerId, int score) {
        if (!players.containsKey(playerId)) players.put(playerId, 0);
        int oriScore = players.get(playerId), newScore = oriScore + score;
        if (oriScore > 0) freq[oriScore]--;
        freq[newScore]++;
        players.put(playerId, newScore);
    }

    public int top(int K) {
        int sum = 0;
        for (int score = freq.length - 1; score >= 0; score--) {
            if (K == 0) return sum;
            int cnt = freq[score];
            while (cnt-- > 0 && K-- > 0) sum += score; // cnt first
        }
        return sum;
    }

    public void reset(int playerId) {
        int score = players.get(playerId);
        freq[score]--;
        players.put(playerId, 0);
    }
}
