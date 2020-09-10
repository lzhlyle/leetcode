package com.lzhlyle.leetcode.tomorrow.no841;

import java.util.*;

public class KeysAndRooms_BFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty())
            for (int key : rooms.get(queue.remove()))
                if (visited.add(key))
                    queue.add(key);
        return visited.size() == n;
    }
}
