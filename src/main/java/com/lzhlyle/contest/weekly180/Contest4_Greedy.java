package com.lzhlyle.contest.weekly180;

import java.util.*;

public class Contest4_Greedy {
    private long max = 0;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1000000007;

        Map<Integer, Set<Integer>> eviMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int e = efficiency[i];
            if (!eviMap.containsKey(e)) eviMap.put(e, new HashSet<>());
            eviMap.get(e).add(i);
        }

        Arrays.sort(efficiency);

        // 优先选效率
        Set<Integer> indexSet = new HashSet<>();
        List<Integer> speeds = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            int e = efficiency[i];

            // 比这个效率高的，所有index
            indexSet.addAll(eviMap.get(e));

            // 这些index对应的speed
            speeds.clear();
            for (Integer j : indexSet) speeds.add(speed[j]);
            Integer[] sortedSpeed = speeds.stream().sorted().toArray(Integer[]::new);
            // 从高到低选，不超过k个
            long sum = 0;
            for (int j = sortedSpeed.length - 1, cnt = 0; j >= 0 && cnt < k; j--, cnt++) {
                sum += sortedSpeed[j];
            }
            long total = sum * e;
            if (total > max) max = total;
        }

        return (int) (max % MOD);
    }

    public static void main(String[] args) {
        Contest4_Greedy contest = new Contest4_Greedy();
        {
            int n = 7, k = 6;
            int[] speed = {1, 4, 1, 9, 4, 4, 4}, efficiency = {8, 2, 1, 7, 1, 8, 4};
            int res = contest.maxPerformance(n, speed, efficiency, k);
            System.out.println(res);
            System.out.println(res == 98);
        }
    }
}
