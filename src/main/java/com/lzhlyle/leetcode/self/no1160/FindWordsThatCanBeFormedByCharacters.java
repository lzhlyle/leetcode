package com.lzhlyle.leetcode.self.no1160;

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        char[] arr = new char[26];
        for (char c : chars.toCharArray()) arr[c - 'a']++;
        int res = 0;
        for (String word : words) {
            boolean learn = true;
            char[] temp = new char[26];
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
                if (temp[c - 'a'] > arr[c - 'a']) {
                    learn = false;
                    break;
                }
            }
            if (learn) res += word.length();
        }
        return res;
    }
}
