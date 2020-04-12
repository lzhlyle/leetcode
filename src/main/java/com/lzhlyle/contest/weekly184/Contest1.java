package com.lzhlyle.contest.weekly184;

import java.util.*;

public class Contest1 {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String wi = words[i], wj = words[j];
                if (wi.length() > wj.length() && valid(wj, wi)) set.add(wj);
                else if (wi.length() < wj.length() && valid(wi, wj)) set.add(wi);
            }
        }
        return new ArrayList<>(set);
    }

    private boolean valid(String shorter, String longer) {
        return longer.contains(shorter);
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            String[] words = {"mass", "as", "hero", "superhero"};
            List<String> res = contest.stringMatching(words);
            System.out.println(res);
        }
    }
}
