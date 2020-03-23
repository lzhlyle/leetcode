package com.lzhlyle.leetcode.tomorrow.no1244;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leaderboard {
    Map<Integer, Integer> players; // player, score
    Map<Integer, Integer> freq; // score, how many players

    public Leaderboard() {
        players = new HashMap<>();
        freq = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (!players.containsKey(playerId)) players.put(playerId, 0);
        int oriScore = players.get(playerId), newScore = oriScore + score;
        if (oriScore > 0) freq.put(oriScore, freq.get(oriScore) - 1);
        freq.put(newScore, freq.getOrDefault(newScore, 0) + 1);
        players.put(playerId, newScore);
    }

    public int top(int K) {
        int[] scores = new int[freq.size()];
        int i = 0;
        for (Integer score : freq.keySet()) scores[i++] = score;
        Arrays.sort(scores);
        int sum = 0;
        for (int j = scores.length - 1; j >= 0; j--) {
            if (K == 0) return sum;
            int cnt = freq.get(scores[j]);
            while (cnt-- > 0 && K-- > 0) sum += scores[j]; // cnt first
        }
        return sum;
    }

    public void reset(int playerId) {
        int score = players.get(playerId);
        freq.put(score, freq.get(score) - 1);
        players.put(playerId, 0);
    }
}
