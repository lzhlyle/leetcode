package com.lzhlyle.leetcode.self.no451;

import java.util.ArrayList;
import java.util.List;

public class SortCharactersByFrequency_BucketSort {
    // O(n)
    public String frequencySort(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;

        int n = s.length();
        List<Integer>[] bucket = new List[n + 1];
        for (int c = 0; c < 256; c++) {
            int f = freq[c];
            if (f == 0) continue;
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(c);
        }

        char[] res = new char[n];
        for (int f = n, i = 0; f >= 0; f--) {
            if (bucket[f] != null) {
                for (int c : bucket[f]) {
                    int curr = f;
                    while (curr-- > 0)
                        res[i++] = (char) c;
                }
            }
        }
        return new String(res);
    }
}
