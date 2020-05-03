package com.lzhlyle.contest.weekly.weekly182;

import java.util.HashSet;
import java.util.Set;

public class Contest4_Adv {
    // wrong
    // 上一个位相同，则可选a到b，否则可选26-evil种
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if (s1.startsWith(evil) && s2.startsWith(evil)) return 0;
        Set<Character> set = new HashSet<>();
        for (char c : evil.toCharArray()) set.add(c);

        long res = 0, MOD = 1000000007;
        boolean common = true;
        int last = 1;
        for (int i = 0; i < n; i++) {
            int possible = 0;
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            common = common && s1.charAt(0) == s2.charAt(0);
            if (common && set.contains(c1)) return 0;


            if (i == 0) {
                for (char c = c1; c <= c2; c++) {
                    if (set.contains(c)) continue;
                    possible++;
                    last = possible;
                }
                res = last;
            } else {
                char begin = 'a', end = 'z';
                // 前一个相同，则当前可选有上下界
                if (s1.charAt(i - 1) == s2.charAt(i - 1)) {
                    begin = c1;
                    end = c2;
                }
                for (char c = begin; c <= end; c++) {
                    if (set.contains(c)) continue;
                    possible++;
                }

                if (end - begin > 1) res += (begin - end) * possible;

                res = (last - 2);
                last = end - begin + 1;
            }
        }
        return (int) (res % MOD);
    }

    public static void main(String[] args) {
        Contest4_Adv contest = new Contest4_Adv();
        {
            int res = contest.findGoodStrings(2, "aa", "da", "b");
            System.out.println(res);
        }
    }
}
