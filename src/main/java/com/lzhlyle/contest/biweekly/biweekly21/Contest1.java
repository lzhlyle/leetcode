package com.lzhlyle.contest.biweekly.biweekly21;

public class Contest1 {
    public String sortString(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] freq = new int[26];
        for (char c : arr) freq[c - 'a']++;

        char[] res = new char[len];
        int ri = 0;
        while (ri < len) {
            // 找最小
            for (int i = 0; i < 26; i++) {
                char c = (char) (i + 'a');
                if (freq[i] > 0) {
                    res[ri++] = c;
                    freq[i]--;
                }
            }

            // 找最大
            for (int i = 25; i >= 0; i--) {
                char c = (char) (i + 'a');
                if (freq[i] > 0) {
                    res[ri++] = c;
                    freq[i]--;
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            String s = "aaaabbbbcccc";
            String res = contest.sortString(s);
            System.out.println(res);
            System.out.println(res.equals("abccbaabccba"));
        }
        {
            String s = "rat";
            String res = contest.sortString(s);
            System.out.println(res);
            System.out.println(res.equals("art"));
        }
        {
            String s = "leetcode";
            String res = contest.sortString(s);
            System.out.println(res);
            System.out.println(res.equals("cdelotee"));
        }
        {
            String s = "ggggggg";
            String res = contest.sortString(s);
            System.out.println(res);
            System.out.println(res.equals("ggggggg"));
        }
    }
}
