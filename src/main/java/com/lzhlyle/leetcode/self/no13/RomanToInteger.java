package com.lzhlyle.leetcode.self.no13;

public class RomanToInteger {
    public int romanToInt(String s) {
        int[] map = init();
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int num = map[arr[i] - 'A'], next = map[arr[i + 1] - 'A'];
            if (num < next) res -= num;
            else res += num;
        }
        return res + map[arr[arr.length - 1] - 'A'];
    }

    private int[] init() {
        int[] map = new int[26];
        char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] arr = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < 7; i++) {
            map[chars[i] - 'A'] = arr[i];
        }
        return map;
    }
}
