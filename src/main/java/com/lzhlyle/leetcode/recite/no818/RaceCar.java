package com.lzhlyle.leetcode.recite.no818;

import java.util.*;

public class RaceCar {
    // bfs
    // timeout
    private int min = Integer.MAX_VALUE;

    public int racecar(int target) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getPos));
        queue.add(new Node(0, 1));
        bfs(0, target, queue, new HashMap<>());
        return min;
    }

    private void bfs(int level, int target, Queue<Node> queue, Map<Integer, Integer> visited) {
        if (queue.isEmpty() || level > min) return;
        Queue<Node> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.pos == target) {
                if (level < min) min = level;
            }
            if (visited.containsKey(node.pos) && visited.get(node.pos) == node.speed) continue; // 其他平行世界已出现过同点、同速的情况
            visited.put(node.pos, node.speed);

            // 超过、但未减速的，背道而驰
            if ((node.pos <= target || node.speed <= 0) && (node.pos >= 0 || node.speed >= 0)) {
                int x = node.pos + node.speed, y = node.speed * 2;
                if (!visited.containsKey(x) || visited.get(x) != y) {
                    next.add(new Node(x, y)); // A
                }
            }

            {
                int x = node.pos, y = node.speed > 0 ? -1 : 1;
                if (!visited.containsKey(x) || visited.get(x) != y) {
                    next.add(new Node(x, y)); // R
                }
            }
        }
        bfs(level + 1, target, next, visited);
    }

    class Node {
        int pos, speed;

        public int getPos() {
            return pos;
        }

        public Node(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pos=" + pos +
                    ", speed=" + speed +
                    '}';
        }
    }

    public static void main(String[] args) {
        int res = new RaceCar().racecar(10000);
        System.out.println(res);
    }
}
