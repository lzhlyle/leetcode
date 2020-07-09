package com.lzhlyle.leetcode.recite.lcci1713;

import java.util.Arrays;

public class ReSpaceLcci_DP_Trie_Adv {
    public int respace(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary)
            trie.insert(word);

        int n = sentence.length();
        char[] arr = sentence.toCharArray();

        int[] dp = new int[n + 1]; // before i
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // substring: [j, i)
            for (int j = i - 1; j >= 0; j--) { // faster
                if (trie.searchWord(arr, j, i))
                    dp[i] = Math.min(dp[i], dp[j]);
                else dp[i] = Math.min(dp[i], dp[j] + i - j);
                if (dp[i] == 0) break; // pruning
            }
        }
        return dp[n];
    }


    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.contains(c)) curr.set(c, new TrieNode());
                curr = curr.get(c);
            }
            curr.setEnd();
        }

        public boolean searchWord(char[] arr, int l, int r) {
            TrieNode curr = root;
            for (int i = l; i < r; i++) {
                char c = arr[i];
                if (!curr.contains(c)) return false;
                curr = curr.get(c);
            }
            return curr.isEnd();
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
