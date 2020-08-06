package com.lzhlyle.leetcode.recite.no211;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
    private Trie trie;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        trie = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return trie.search(word);
    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.contains(c)) curr.set(c, new TrieNode());
                curr = curr.get(c);
            }
            curr.setEnd();
        }

        private boolean searchPrefix(char[] arr, int i, TrieNode from) {
            TrieNode curr = from;
            while (i < arr.length && arr[i] != '.') {
                if (!curr.contains(arr[i])) return false;
                else curr = curr.get(arr[i++]);
            }
            if (i == arr.length) return curr.end();

            for (TrieNode next : curr.getList())
                if (searchPrefix(arr, i + 1, next))
                    return true;
            return false;
        }

        boolean search(String regex) {
            return searchPrefix(regex.toCharArray(), 0, root);
        }
    }

    class TrieNode {
        private TrieNode[] links;
        private boolean end;

        TrieNode() {
            links = new TrieNode[26];
            end = false;
        }

        TrieNode get(char c) {
            return links[c - 'a'];
        }

        void set(char c, TrieNode next) {
            links[c - 'a'] = next;
        }

        List<TrieNode> getList() {
            List<TrieNode> res = new ArrayList<>();
            for (char c = 'a'; c <= 'z'; c++)
                if (links[c - 'a'] != null)
                    res.add(links[c - 'a']);
            return res;
        }

        boolean contains(char c) {
            return links[c - 'a'] != null;
        }

        void setEnd() {
            end = true;
        }

        boolean end() {
            return end;
        }
    }
}