package com.lzhlyle.leetcode.recite.no14;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        Trie trie = new Trie();
        String shortest = strs[0];

        for (String str : strs) {
            if (str.length() < shortest.length()) shortest = str;
            trie.insert(str);
        }

        return trie.searchLongestPrefix(shortest);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String res = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(res);
    }
}
