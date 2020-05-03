package com.lzhlyle.contest.biweekly.biweekly21;

public class Contest2 {
    // brute force: timeout
    public int findTheLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        for (int l = 0; l < s.length(); l++) {
            for (int r = s.length() - 1; r >= l; r--) {
                int len = r - l + 1;
                if (len > max && valid(arr, l, r)) {
                    max = len;
                }
            }
        }
        return max;
    }

    private boolean valid(char[] arr, int l, int r) {
        int[] freq = new int[5];
        for (int j = l; j <= r; j++) {
            if (arr[j] == 'a') freq[0]++;
            else if (arr[j] == 'e') freq[1]++;
            else if (arr[j] == 'i') freq[2]++;
            else if (arr[j] == 'o') freq[3]++;
            else if (arr[j] == 'u') freq[4]++;
        }
        for (int cnt : freq) if (cnt % 2 != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
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
