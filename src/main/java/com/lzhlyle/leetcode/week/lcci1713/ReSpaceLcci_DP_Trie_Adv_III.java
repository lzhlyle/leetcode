package com.lzhlyle.leetcode.week.lcci1713;

import java.util.Arrays;

public class ReSpaceLcci_DP_Trie_Adv_III {
    // reverse trie
    public int respace(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary)
            trie.insert(word);

        int n = sentence.length();
        char[] arr = sentence.toCharArray();

        int[] dp = new int[n + 1]; // before i
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // default unknown
            // substring: [j, i)
            TrieNode curr = trie.root;
            for (int j = i - 1; j >= 0; j--) { // faster
                curr = curr.get(arr[j]);
                if (curr == null) break; // pruning
                if (curr.isEnd()) dp[i] = Math.min(dp[i], dp[j]);
                if (dp[i] == 0) break; // pruning
            }
        }
        return dp[n];
    }


    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        // reverse insert
        public void insert(String word) {
            TrieNode curr = root;
            char[] arr = word.toCharArray();
            int n = arr.length;
            for (int i = n - 1; i >= 0; i--) {
                char c = arr[i];
                if (!curr.contains(c)) curr.set(c, new TrieNode());
                curr = curr.get(c);
            }
            curr.setEnd();
        }
    }

    class TrieNode {
        private TrieNode[] arr;
        private boolean end;

        TrieNode() {
            arr = new TrieNode[26];
            end = false;
        }

        public TrieNode get(char c) {
            return arr[c - 'a'];
        }

        public void set(char c, TrieNode next) {
            arr[c - 'a'] = next;
        }

        public boolean contains(char c) {
            return arr[c - 'a'] != null;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd() {
            end = true;
        }
    }
}
