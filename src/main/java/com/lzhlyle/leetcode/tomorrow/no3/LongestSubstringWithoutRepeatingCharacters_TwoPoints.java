package com.lzhlyle.leetcode.self.no3;

public class LongestSubstringWithoutRepeatingCharacters_TwoPoints {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        boolean[] visited = new boolean[256]; // instead of Set
        char[] arr = s.toCharArray();
        for (int l = 0, r = 0; r < arr.length; r++) {
            char c = arr[r];
            while (visited[c]) {
                visited[arr[l++]] = false;
            }
            visited[c] = true;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
