package com.lzhlyle.leetcode.recite.no139;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak_Trie {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Trie trie = new Trie();
        for (String word : wordDict)
            trie.insert(word);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int from = queue.remove();
            List<Integer> ends = trie.searchPrefixes(s.toCharArray(), from);
            for (int end : ends) {
                if (end == n - 1) return true;
                if (visited[end + 1]) continue;
                queue.add(end + 1);
                visited[end + 1] = true;
            }
        }
        return false;
    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.contains(c))
                    curr.set(c, new TrieNode());
                curr = curr.get(c);
            }
            curr.setEnd();
        }

        // 返回可能的结尾
        public List<Integer> searchPrefixes(char[] chars, int from) {
            List<Integer> res = new ArrayList<>();
            TrieNode curr = root;
            for (int i = from; i < chars.length; i++) {
                curr = curr.get(chars[i]);
                if (curr == null) break;
                else if (curr.isEnd()) res.add(i);
            }
            return res;
        }
    }

    class TrieNode {
        private TrieNode[] arr;
        private boolean isEnd;

        TrieNode() {
            arr = new TrieNode[256];
            isEnd = false;
        }

        public TrieNode get(char c) {
            return arr[c];
        }

        public void set(char c, TrieNode next) {
            arr[c] = next;
        }

        public boolean contains(char c) {
            return arr[c] != null;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }
}
