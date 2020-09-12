package com.lzhlyle.contest.season.fall2020.solo;

public class Contest1 {
    public int calculate(String s) {
        int x = 1, y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') x = calc(c, x, y);
            else y = calc(c, x, y);
        }
        return x + y;
    }

    private int calc(char c, int x, int y) {
        if (c == 'A') {
            return 2 * x + y;
        } else {
            return 2 * y + x;
        }
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
