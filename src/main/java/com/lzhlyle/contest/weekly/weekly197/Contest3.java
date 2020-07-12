package com.lzhlyle.contest.weekly.weekly197;

import java.util.*;

public class Contest3 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Ele[] adj = new Ele[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new Ele();
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            double p = succProb[i];

            adj[a].tos.add(b);
            adj[a].ps.add(p);

            adj[b].tos.add(a);
            adj[b].ps.add(p);
        }

        double[] parr = new double[n];
        Arrays.fill(parr, 0d);
        parr[start] = 1d;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            while (!queue.isEmpty()) {
                int from = queue.remove();
                for (int i = 0; i < adj[from].tos.size(); i++) {
                    int to = adj[from].tos.get(i);
                    double p = adj[from].ps.get(i);

                    if (to == from) continue;
                    if (p == 0d) continue;
                    if (parr[from] * p > parr[to]) {
                        parr[to] = parr[from] * p;
                        set.add(to);
                    }
                }
            }
            queue = new LinkedList<>(set);
        }

        return parr[end];
    }

    class Ele {
        List<Integer> tos;
        List<Double> ps;

        Ele() {
            this.tos = new ArrayList<>();
            this.ps = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
