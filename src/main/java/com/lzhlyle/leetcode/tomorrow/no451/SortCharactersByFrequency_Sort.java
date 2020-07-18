package com.lzhlyle.leetcode.tomorrow.no451;

import java.util.Arrays;

public class SortCharactersByFrequency_Sort {
    // O(nlog(n))
    public String frequencySort(String s) {
        int[][] freq = new int[256][2];
        for (char c : s.toCharArray()) {
            freq[c][0] = c;
            freq[c][1]++;
        }

        Arrays.sort(freq, (a, b) -> b[1] - a[1]);

        char[] res = new char[s.length()];
        int i = 0;
        for (int[] cf : freq)
            while (cf[1]-- > 0)
                res[i++] = (char) cf[0];
        return new String(res);
    }
}
