package com.lzhlyle.contest.weekly.weekly187;

import java.util.*;

public class Contest4_LC {
    // bfs
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        int sum = 0;
        for (int[] row : mat) sum += row[0];
        Node begin = new Node(sum, new int[m]);

        Set<Node> visited = new HashSet<>();
        visited.add(begin);
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        queue.add(begin);

        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            Node node = queue.remove();
            if (cnt == k) return node.sum;

            for (int i = 0; i < m; i++) {
                int nextIndex = node.choose[i] + 1;
                if (nextIndex < n) {
                    int[] currChoose = node.choose.clone();
                    currChoose[i]++;
                    Node newNode = new Node(node.sum - mat[i][node.choose[i]] + mat[i][nextIndex], currChoose);
                    if (!visited.contains(newNode)) {
                        visited.add(newNode);
                        queue.add(newNode);
                    }
                }
            }
        }
        return 0;
    }

    class Node {
        int sum;
        int[] choose;

        public Node(int sum, int[] choose) {
            this.sum = sum;
            this.choose = choose;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return sum == node.sum &&
                    Arrays.equals(choose, node.choose);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(sum);
            result = 31 * result + Arrays.hashCode(choose);
            return result;
        }
    }
}
