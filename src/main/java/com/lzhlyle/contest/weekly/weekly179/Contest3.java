package com.lzhlyle.contest.weekly.weekly179;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Contest3 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) return 0;

        // 构造结点
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < informTime.length; i++) {
            map.put(i, new TreeNode(informTime[i]));
        }
        // 链接结点
        TreeNode root = null;
        for (int i = 0; i < manager.length; i++) {
            if (i == headID) root = map.get(headID);
            else map.get(manager[i]).subList.add(map.get(i));
        }
        if (root == null) return -1;
        return inform(root);
    }

    private int inform(TreeNode curr) {
        if (curr == null || curr.time == 0) return 0;
        int maxSub = 0;
        for (TreeNode sub : curr.subList) {
            int m = inform(sub);
            if (m > maxSub) maxSub = m;
        }
        return maxSub + curr.time;
    }

    class TreeNode {
        int time;
        List<TreeNode> subList;

        TreeNode(int informTime) {
            this.time = informTime;
            this.subList = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            int n = 1, headID = 0;
            int[] manager = {-1}, informTime = {0};
            int res = contest.numOfMinutes(n, headID, manager, informTime);
            System.out.println(res);
            System.out.println(res == 0);
        }
        {
            int n = 6, headID = 2;
            int[] manager = {2, 2, -1, 2, 2, 2}, informTime = {0, 0, 1, 0, 0, 0};
            int res = contest.numOfMinutes(n, headID, manager, informTime);
            System.out.println(res);
            System.out.println(res == 1);
        }
        {
            int n = 7, headID = 6;
            int[] manager = {1, 2, 3, 4, 5, 6, -1}, informTime = {0, 6, 5, 4, 3, 2, 1};
            int res = contest.numOfMinutes(n, headID, manager, informTime);
            System.out.println(res);
            System.out.println(res == 21);
        }
        {
            int n = 15, headID = 0;
            int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6}, informTime = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
            int res = contest.numOfMinutes(n, headID, manager, informTime);
            System.out.println(res);
            System.out.println(res == 3);
        }
        {
            int n = 4, headID = 2;
            int[] manager = {3, 3, -1, 2}, informTime = {0, 0, 162, 914};
            int res = contest.numOfMinutes(n, headID, manager, informTime);
            System.out.println(res);
            System.out.println(res == 1076);
        }
    }
}
