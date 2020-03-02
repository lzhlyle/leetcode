package com.lzhlyle.leetcode.recite.no14;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c)) curr.setChar(c, new TrieNode());
            curr = curr.getChar(c);
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        TrieNode last = searchPrefix(word);
        return last != null && last.isEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            curr = curr.getChar(c);
            if (curr == null) return null;
        }
        return curr;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public String searchLongestPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.contains(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                prefix.append(curLetter);
                node = node.getChar(curLetter);
            } else return prefix.toString();

        }
        return prefix.toString();
    }
}
