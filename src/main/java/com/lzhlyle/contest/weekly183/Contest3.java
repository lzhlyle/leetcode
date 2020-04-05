package com.lzhlyle.contest.weekly183;

public class Contest3 {
    private String[] valid = {"aaa", "bbb", "ccc"};
    private int maxLen = 0;
    private String res = "";

    // tle
    public String longestDiverseString(int a, int b, int c) {
        if (a > 2 * (b + c + 1)) a = 2 * (b + c + 1);
        else if (b > 2 * (a + c + 1)) b = 2 * (a + c + 1);
        else if (c > 2 * (b + a + 1)) c = 2 * (b + a + 1);
        dfs(0, "", a, b, c);
        return res;
    }

    private void dfs(int level, String curr, int a, int b, int c) {
        for (int i = 0; i < 3; i++) {
            if (curr.contains(valid[i])) return;
        }

        int len = curr.length();
        if (len > maxLen) {
            maxLen = len;
            res = curr;
        }

        if (a > 0) dfs(level + 1, curr + "a", a - 1, b, c);
        if (b > 0) dfs(level + 1, curr + "b", a, b - 1, c);
        if (c > 0) dfs(level + 1, curr + "c", a, b, c - 1);
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            int a = 4, b = 42, c = 7;
            String res = contest.longestDiverseString(a, b, c);
            System.out.println(res);
        }
    }
}
