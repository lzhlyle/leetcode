package com.lzhlyle.contest.biweekly.biweekly27;

import java.util.*;

public class Contest3_II {
    // 路径压缩
    public List<Boolean> checkIfPrerequisite(int n, int[][] pres, int[][] queries) {
        Set<Integer>[] toFrom = new Set[n]; // (to, from)
        for (int i = 0; i < n; i++) {
            toFrom[i] = new HashSet<>();
        }

        int[] outs = new int[n];
        for (int[] p : pres) {
            int from = p[0], to = p[1];
            toFrom[to].add(from);
            outs[from]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int to = 0; to < n; to++) {
            if (outs[to] == 0) queue.add(to);
        }

        // 路径压缩
        Set<Integer>[] fromTos = new Set[n]; // index: from, values: tos
        for (int i = 0; i < n; i++) {
            fromTos[i] = new HashSet<>();
        }

        while (!queue.isEmpty()) {
            Set<Integer> nextSet = new HashSet<>();
            while (!queue.isEmpty()) {
                int to = queue.remove();
                for (int from : toFrom[to]) {
                    fromTos[from].add(to);
                    fromTos[from].addAll(fromTos[to]);
                    nextSet.add(from);
                }
            }
            queue = new LinkedList<>(nextSet);
        }

        int qlen = queries.length;
        List<Boolean> res = new ArrayList<>(qlen);
        for (int[] q : queries) {
            int from = q[0], to = q[1];
            res.add(fromTos[from].contains(to));
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3_II contest = new Contest3_II();
        {

        }
    }
}
