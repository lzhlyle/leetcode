package com.lzhlyle.contest.biweekly.biweekly33;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contest2 {
    // O(n)
    // 入度为 0 的
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(i);
        for (List<Integer> e : edges)
            set.remove(e.get(1));
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
