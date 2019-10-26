package com.lzhlyle.leetcode.tomorrow.no70;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    private Map<Integer, Integer> cache;

    // fib，倒退，递归，缓存
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;

        cache = new HashMap<>();

        return _fib(n);
    }

    private int _fib(int n) {
        // terminator
        if (n <= 2) return n;
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // process
        // drill down
        int res = _fib(n - 1) + _fib(n - 2);
        cache.put(n, res);

        return res;
        // reverse state
    }
}
