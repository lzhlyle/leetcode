package com.lzhlyle.contest.biweekly22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contest2 {
    private Map<Integer, Set<Integer>> map = new HashMap<>();

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        for (int[] seat : reservedSeats) {
            int i = seat[0] - 1, j = seat[1] - 1;
            if (!map.containsKey(i)) map.put(i, new HashSet<>());
            map.get(i).add(j);
        }
        int sum = 0, empty = n;
        for (Integer i : map.keySet()) {
            sum += calc(i);
            empty--;
        }
        return sum + empty * 2;
    }

    private int calc(int i) {
        short row = 0b0;
        for (Integer j : map.get(i)) row |= 1 << j;
        int cnt = 0;
        if ((row >> 1) == ((row >> 5) << 4)) cnt++;
        if ((row >> 5) == ((row >> 9) << 4)) cnt++;
        if (cnt == 0 && ((row >> 3) == (row >> 7) << 4)) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
