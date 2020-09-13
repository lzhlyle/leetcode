package com.lzhlyle.contest.weekly.weekly206;

public class Contest4 {
    public boolean isTransformable(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int[] freq = new int[10];
        int n = sarr.length;

        // 同位置上，对于 s[i] 及之前的，不能出现比 t[i] 小的
        for (int i = 0; i < n; i++) {
            freq[sarr[i] - '0']++;
            freq[tarr[i] - '0']--;
            if (freq[tarr[i] - '0'] == 0) continue;
            for (int tc = tarr[i] - 1; tc >= '0'; tc--)
                if (freq[tc - '0'] > 0)
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {
            
        }
    }
}
