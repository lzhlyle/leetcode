package com.lzhlyle.contest.weekly.weekly178;

import java.util.*;
import java.util.stream.Collectors;

public class Contest2_LC {
    public String rankTeams(String[] votes) {
        // key是参赛团队，value是该团队每个排位获得的票数
        Map<Character, int[]> teamRankMap = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int[] rankArr = teamRankMap.getOrDefault(vote.charAt(i), new int[26]);
                rankArr[i]++;
                teamRankMap.put(vote.charAt(i), rankArr);
            }
        }

        List<Map.Entry<Character, int[]>> teamRankList = new ArrayList<>(teamRankMap.entrySet());
        teamRankList.sort((team1, team2) -> {
            int[] ranks1 = team1.getValue();
            int[] ranks2 = team2.getValue();
            // 根据投票排序
            for (int i = 0; i < 26; i++) {
                if (ranks1[i] != ranks2[i]) {
                    return ranks2[i] - ranks1[i];
                }
            }
            // 字母顺序排序
            return team1.getKey() - team2.getKey();
        });

        //转换为字符串输出
        return teamRankList.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Contest2_LC contest = new Contest2_LC();
        {
            String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
            String res = contest.rankTeams(votes);
            System.out.println(res);
            System.out.println(res.equals("ACB"));
        }
    }
}
