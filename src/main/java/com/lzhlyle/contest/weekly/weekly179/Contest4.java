package com.lzhlyle.contest.weekly.weekly179;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Contest4 {
    // wrong: 无向图，不应有parent，应提前确定要经过的点
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1) return 0;
        // 构造节点
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, new TreeNode(i));
        // 链接节点
        for (int[] edge : edges) {
            TreeNode from = map.get(edge[0]);
            TreeNode to = map.get(edge[1]);
            to.parent = from;
            from.subList.add(to);
        }
        TreeNode node = map.get(target);

        int step = 0, branches = 1;
        while (node != null && node.num != 1) {
            step++;
            node = node.parent;
            if (node != null) branches *= node.subList.size();
        }

        if (t < step) return 0;
        return 1.0 / branches;
    }

    class TreeNode {
        int num;
        TreeNode parent;
        List<TreeNode> subList;

        TreeNode(int num) {
            this.num = num;
            this.parent = null;
            this.subList = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
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
