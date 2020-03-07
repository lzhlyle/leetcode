package com.lzhlyle.contest.biweekly21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Contest2_Adv {
    // wrong
    public int findTheLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, max = 0, l = len / 2, r = l + 1; // 缺最后一个
        Set<Character> oddSet = new HashSet<>(); // 奇数
        Set<Character> valid = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        while (l >= 0 && r < len) {
            char cl = arr[l], cr = arr[r];

            if (valid.contains(cl)) {
                if (oddSet.contains(cl)) oddSet.remove(cl);
                else oddSet.add(cl);
            }
            if (oddSet.isEmpty()) max = r - l + 1;
            l--;

            if (valid.contains(cr)) {
                if (oddSet.contains(cr)) oddSet.remove(cr);
                else oddSet.add(cr);
            }
            if (oddSet.isEmpty()) max = r - l + 1;
            r++;
        }

        char last = arr[len - 1];

        // exclude
        if (!valid.contains(last)) return max + 1;

        // include
        if (oddSet.contains(last)) oddSet.remove(last);
        else oddSet.add(last);
        if (oddSet.isEmpty()) return max + 1;
        else return max;
    }

    public static void main(String[] args) {
        Contest2_Adv contest = new Contest2_Adv();
        {
            String s = "id";
            int res = contest.findTheLongestSubstring(s);
            System.out.println(res);
            System.out.println(res == 1);
        }
        {
            String s = "eleetminicoworoep";
            int res = contest.findTheLongestSubstring(s);
            System.out.println(res);
            System.out.println(res == 13);
        }
        {
            String s = "leetcodeisgreat";
            int res = contest.findTheLongestSubstring(s);
            System.out.println(res);
            System.out.println(res == 5);
        }
        {
            String s = "bcbcbc";
            int res = contest.findTheLongestSubstring(s);
            System.out.println(res);
            System.out.println(res == 6);
        }
    }
}
