package com.lzhlyle.contest.biweekly25;

import java.util.ArrayList;
import java.util.List;

public class Contest1 {
    public List<Boolean> kidsWithCandies(int[] candies, int e) {
        int max = 0;
        for (int c : candies) max = Math.max(max, c);
        List<Boolean> res = new ArrayList<>(candies.length);
        for (int c : candies) {
            res.add(c + e >= max);
        }
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
