package com.lzhlyle.leetcode.recite.no13;

public class RomanToInteger {
    public int romanToInt(String s) {
        int[] map = iniMap();
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            int c1 = arr[i] - 'A', c2 = arr[i + 1] - 'A';
            if (map[c1] < map[c2]) res -= map[c1];
            else res += map[c1];
        }
        return res + map[arr[arr.length - 1] - 'A'];
    }

    private int[] iniMap() {
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        return map;
    }
}
