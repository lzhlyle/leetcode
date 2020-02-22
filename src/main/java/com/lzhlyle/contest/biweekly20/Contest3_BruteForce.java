package com.lzhlyle.contest.biweekly20;

public class Contest3_BruteForce {

    public int numberOfSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (valid(s.substring(i, j))) count++;
            }
        }
        return count;
    }

    private boolean valid(String curr) {
        int[] freq = new int[3];
        for (char c : curr.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i : freq) {
            if (i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Contest3_BruteForce contest = new Contest3_BruteForce();
        {
            int res = contest.numberOfSubstrings("abcabc");
            System.out.println(res);
        }
    }
}
