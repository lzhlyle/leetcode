package com.lzhlyle.templates.algorithm.cache;

import java.util.BitSet;

public class BloomFilter {
    private static BloomFilter ourInstance = new BloomFilter();

    public static BloomFilter getInstance() {
        return ourInstance;
    }

    private BitSet filter;

    private BloomFilter() {
        this.filter = new BitSet(1024 * 1024 * 10); // 10Mb
    }

    public void add(int num) {
        for (int seed : _SEEDS) filter.set(this.hashFunc(num, seed), true);
    }

    public boolean contains(int num) {
        boolean res = true;
        int i = _SEEDS.length;
        while (i-- > 0 && res) res = filter.get(this.hashFunc(num, _SEEDS[i]));
        return res;
    }

    private static final int[] _SEEDS = {2019, 12, 1};

    private int hashFunc(int num, int seed) {
        return Integer.hashCode(num * seed) % filter.size();
    }
}
