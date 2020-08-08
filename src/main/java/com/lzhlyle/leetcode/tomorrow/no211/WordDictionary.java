package com.lzhlyle.leetcode.tomorrow.no211;

import java.util.Arrays;
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
        return trie.searchRegex(word);
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

        private boolean searchRegexFrom(char[] arr, int i, TrieNode from) {
            TrieNode curr = from;
            while (i < arr.length && arr[i] != '.') {
                if (!curr.contains(arr[i])) return false;
                else curr = curr.get(arr[i++]);
            }
            if (i == arr.length) return curr.end();

            for (TrieNode tn : curr.getLinks())
                if (tn != null)
                    if (searchRegexFrom(arr, i + 1, tn))
                        return true;
            return false;
        }

        boolean searchRegex(String regex) {
            return searchRegexFrom(regex.toCharArray(), 0, root);
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

        boolean contains(char c) {
            return links[c - 'a'] != null;
        }

        boolean end() {
            return end;
        }

        void setEnd() {
            end = true;
        }

        List<TrieNode> getLinks() {
            return Arrays.asList(links);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */