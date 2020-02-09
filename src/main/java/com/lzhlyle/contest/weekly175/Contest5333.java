package com.lzhlyle.contest.weekly175;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 *
 * 5333. 制造字母异位词的最小步骤数
 */
public class Contest5333 {
    public int minSteps(String s, String t) {
        int[] sFreq = new int[26], tFreq = new int[26];
        int len = s.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < len; i++) {
            sFreq[sChars[i] - 'a']++;
            tFreq[tChars[i] - 'a']++;
        }

        int min = 0;
        for (int i = 0; i < 26; i++) {
            min += Math.abs(sFreq[i] - tFreq[i]);
        }
        return min / 2;
    }

    public static void main(String[] args) {
        Contest5333 contest = new Contest5333();
        {
            String s = "bab", t = "aba";
            int res = contest.minSteps(s, t);
            System.out.println(res);
        }
        {
            String s = "leetcode", t = "practice";
            int res = contest.minSteps(s, t);
            System.out.println(res);
        }
        {
            String s = "anagram", t = "mangaar";
            int res = contest.minSteps(s, t);
            System.out.println(res);
        }
        {
            String s = "xxyyzz", t = "xxyyzz";
            int res = contest.minSteps(s, t);
            System.out.println(res);
        }
        {
            String s = "friend", t = "family";
            int res = contest.minSteps(s, t);
            System.out.println(res);
        }
    }
}
