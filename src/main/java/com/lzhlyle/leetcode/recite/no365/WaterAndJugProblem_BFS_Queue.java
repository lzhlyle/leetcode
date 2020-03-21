package com.lzhlyle.leetcode.recite.no365;

import java.util.*;

public class WaterAndJugProblem_BFS_Queue {
    private Map<Integer, Set<Integer>> visited = new HashMap<>();
    private Queue<Node> queue = new LinkedList<>();

    public boolean canMeasureWater(int x, int y, int z) {
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int i = node.x, j = node.y;
            if (i + j == z) return true;

            appendNode(x, j);
            appendNode(i, y);
            appendNode(0, j);
            appendNode(i, 0);
            appendNode(x, j);

            if (y - j > i) appendNode(0, i + j);
            else appendNode(i - (y - j), y);

            if (x - i > j) appendNode(i + j, 0);
            else appendNode(x, j - (x - i));
        }
        return false;
    }

    private void appendNode(int i, int j) {
        if (visited.containsKey(i) && visited.get(i).contains(j)) return;

        if (!visited.containsKey(i)) visited.put(i, new HashSet<>());
        visited.get(i).add(j);
        queue.add(new Node(i, j));
    }

    class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
