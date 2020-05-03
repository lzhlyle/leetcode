package com.lzhlyle.contest.weekly.weekly179;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Contest4_Adv {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1) return 1;
        // 构造节点
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, new TreeNode(i));
        // 记录链接
        Map<TreeNode, List<TreeNode>> abMap = new HashMap<>(), baMap = new HashMap<>();
        for (int[] edge : edges) {
            TreeNode a = map.get(edge[0]);
            TreeNode b = map.get(edge[1]);
            if (!abMap.containsKey(a)) abMap.put(a, new LinkedList<>());
            if (!baMap.containsKey(b)) baMap.put(b, new LinkedList<>());
            abMap.get(a).add(b);
            baMap.get(b).add(a);
        }
        // 链接节点
        TreeNode from = map.get(1); // root
        dfs(from, abMap, baMap);

        TreeNode node = map.get(target);
        int step = 0, branches = 1;
        while (node != null && node.num != 1) {
            step++;
            node = node.parent;
            if (node != null) branches *= node.subList.size();
        }

        if (t < step) return 0; // 时间不够
        if (t > step && map.get(target).subList.size() > 0) return 0; // 跳过了
        return 1.0 / branches;
    }

    private void dfs(TreeNode from, Map<TreeNode, List<TreeNode>> abMap, Map<TreeNode, List<TreeNode>> baMap) {
        List<TreeNode> subs = new LinkedList<>();
        if (abMap.containsKey(from)) subs.addAll(abMap.get(from));
        if (baMap.containsKey(from)) subs.addAll(baMap.get(from));
        for (TreeNode sub : subs) {
            if (sub == from.parent) continue;
            sub.parent = from;
            from.subList.add(sub);
            dfs(sub, abMap, baMap);
        }
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
        Contest4_Adv contest = new Contest4_Adv();
        {
            int n = 8, t = 7, target = 7;
            int[][] edges = {{2, 1}, {3, 2}, {4, 1}, {5, 1}, {6, 4}, {7, 1}, {8, 7}};
            double res = contest.frogPosition(n, edges, t, target);
            System.out.println(res);
        }
        {
            int n = 3, t = 1, target = 2;
            int[][] edges = {{2, 1}, {3, 2}};
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
