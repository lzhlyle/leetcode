package com.lzhlyle.contest.weekly.weekly203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contest1 {
    public List<Integer> mostVisited(int n, int[] arr) {
        int a0 = arr[0], ax = arr[arr.length - 1];
        if (a0 == ax) return Collections.singletonList(a0);

        List<Integer> res = new ArrayList<>();
        if (a0 > ax) {
            for (int v = 1; v <= ax; v++) res.add(v);
            for (int v = a0; v <= n; v++) res.add(v);
            return res;
        }

        // a0 < ax
        for (int v = a0; v <= ax; v++) res.add(v);
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
