package com.lzhlyle.contest.weekly.weekly189;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contest3 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        List<Set<String>> valids = new ArrayList<>(n);
        for (List<String> favoriteCompany : favoriteCompanies) {
            valids.add(new HashSet<>(favoriteCompany));
        }
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<String> companies = favoriteCompanies.get(i);

            // 检查其他人
            boolean isAnySub = false;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // 检查每个收藏
                Set<String> set = valids.get(j);
                if (companies.size() > set.size()) continue;

                boolean isSub = true;
                for (String company : companies) {
                    if (!set.contains(company)) {
                        isSub = false;
                        break;
                    }
                }

                if (isSub) {
                    isAnySub = true;
                    break;
                }
            }

            if (!isAnySub) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
