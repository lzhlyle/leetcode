package com.lzhlyle.contest.weekly.weekly188;

import java.util.ArrayList;
import java.util.List;

public class Contest1 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1, t = 0; i <= n && t < target.length; i++) {
            res.add("Push");
            if (i != target[t]) res.add("Pop");
            else t++;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
