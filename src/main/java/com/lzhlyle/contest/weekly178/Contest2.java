package com.lzhlyle.contest.weekly178;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contest2 {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        char[] res = new char[len];
        Set<Character> visited = new HashSet<>();
        int[] freq = new int[26];
        Map<Integer, Set<Character>> map = new HashMap<>(); // 记录每一名的并列情况
        for (int i = 0, curr = 0; i < len; i++) {
            if (!map.containsKey(curr)) map.put(curr, new HashSet<>());
            for (String vote : votes) {
                freq[vote.charAt(i) - 'A']++;
            }

            int max = 0;
            char maxCh = 0;
            for (int fi = 0; fi < 26; fi++) {
                char ch = (char) (fi + 'A');
                if (visited.contains(ch)) continue;
                if (freq[fi] > max) {
                    max = freq[fi];
                    maxCh = ch;
                } else if (max > 0 && freq[fi] == max) {
                    // 出现并列
                    map.get(curr).add(maxCh);
                    map.get(curr).add(ch);
                    maxCh = 0;
                }
            }
            if (maxCh > 0) {
                // 需等待...???
                visited.add(res[curr] = maxCh);
                map.get(curr).remove(maxCh);
                curr++;
            }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
//        {
//            String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
//            String res = contest.rankTeams(votes);
//            System.out.println(res);
//            System.out.println(res.equals("ACB"));
//        }
        {
            String[] votes = {"WXYZ", "XYZW"};
            String res = contest.rankTeams(votes);
            System.out.println(res);
            System.out.println(res.equals("XWYZ"));
        }
        {
            String[] votes = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
            String res = contest.rankTeams(votes);
            System.out.println(res);
            System.out.println(res.equals("ZMNAGUEDSJYLBOPHRQICWFXTVK"));
        }
        {
            String[] votes = {"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};
            String res = contest.rankTeams(votes);
            System.out.println(res);
            System.out.println(res.equals("ABC"));
        }
        {
            String[] votes = {"M", "M", "M", "M"};
            String res = contest.rankTeams(votes);
            System.out.println(res);
            System.out.println(res.equals("M"));
        }
    }
}
