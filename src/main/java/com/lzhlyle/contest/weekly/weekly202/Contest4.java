package com.lzhlyle.contest.weekly.weekly202;

import java.util.HashMap;
import java.util.Map;

public class Contest4 {
    public int minDays(int n) {
        return dfs(n, new HashMap<>());
    }

    private int dfs(int n, Map<Integer, Integer> map) {
        if (n == 0) return 0;
        if (map.containsKey(n)) return map.get(n);

        int res = n, n2 = n / 2, n3 = n / 3;
        res = Math.min(res, dfs(n2, map) + 1 + n - (n2 * 2));
        res = Math.min(res, dfs(n3, map) + 1 + n - (n3 * 3));

        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
