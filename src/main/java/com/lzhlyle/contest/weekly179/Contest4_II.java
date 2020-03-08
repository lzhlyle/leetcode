package com.lzhlyle.contest.weekly179;

import java.util.*;

public class Contest4_II {
    // wrong: 无向图，不应有parent，应提前确定要经过的点
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1) return 0;
        // 构造节点
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, new TreeNode(i));
        // 链接节点
        for (int[] edge : edges) {
            TreeNode n1 = map.get(edge[0]);
            TreeNode n2 = map.get(edge[1]);
            n1.neighbors.add(n2);
            n2.neighbors.add(n1);
        }
        TreeNode node = map.get(target);

        // twoEnd-bfs + path
        Set<TreeNode> visited = new HashSet<>(Collections.singleton(node));
        Queue<TreeNode> queue = new LinkedList<>(Collections.singleton(node));
        Map<TreeNode, List<TreeNode>> path = new HashMap<>();
        int step = bfs(0, map.get(1), queue, visited, path), branches = 1;
        if (step == -1 || t < step) return 0;

        // path

        return 1.0 / branches;
    }

    private int bfs(int step, TreeNode begin, Queue<TreeNode> queue, Set<TreeNode> visited, Map<TreeNode, List<TreeNode>> path) {
        if (queue.isEmpty()) return -1;
        step++;
        Queue<TreeNode> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            for (TreeNode neighbor : node.neighbors) {
                if (neighbor.equals(begin)) return step;
                if (visited.contains(neighbor)) continue;
                if (!path.containsKey(neighbor)) path.put(neighbor, new LinkedList<>());
                path.get(neighbor).add(node);
                next.add(neighbor);
                visited.add(neighbor);
            }
        }
        return bfs(step, begin, next, visited, path);
    }

    class TreeNode {
        int num;
        List<TreeNode> neighbors;

        TreeNode(int num) {
            this.num = num;
            this.neighbors = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        Contest4_II contest = new Contest4_II();
        {
            int n = 3, t = 1, target = 2;
            int[][] edges = {{2, 1}, {3, 2}};
            double res = contest.frogPosition(n, edges, t, target);
            System.out.println(res);
        }
        {
            int n = 8, t = 7, target = 7;
            int[][] edges = {{2, 1}, {3, 2}, {4, 1}, {5, 1}, {6, 4}, {7, 1}, {8, 7}};
            double res = contest.frogPosition(n, edges, t, target);
            System.out.println(res);
        }
        {
            int n = 7, t = 2, target = 4;
            int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
            double res = contest.frogPosition(n, edges, t, target);
            System.out.println(res);
        }
        {
            int n = 7, t = 1, target = 7;
            int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
            double res = contest.frogPosition(n, edges, t, target);
            System.out.println(res);
        }
        {
            int n = 7, t = 20, target = 6;
            int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
            double res = contest.frogPosition(n, edges, t, target);
            System.out.println(res);
        }
    }
}
