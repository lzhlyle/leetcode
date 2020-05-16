package com.lzhlyle.contest.biweekly.biweekly26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contest2 {
    public List<String> simplifiedFractions(int n) {
        if (n == 1) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) { // digit 分母
            for (int j = 1; j < i; j++) { // j 分子
                int gcd = gcd(i, j);
                if (gcd != 1) continue;
                res.add(j + "/" + i);
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
