package com.lzhlyle.contest.biweekly.biweekly26;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// wa
public class Contest4_II {
    public String largestNumber(int[] costs, int target) {
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.cost == b.cost ? b.digit - a.digit : a.cost - b.cost);
        int min = costs[0];
        for (int i = 0; i < 9; i++) {
            min = Math.min(min, costs[i]);
            queue.add(new Node(costs[i], i + 1));
        }

        Stack<Integer> list = dfs(0, queue, target, 0, new Stack<>(), min);
        System.out.println(list);
        return "0";
    }

    private Stack<Integer> dfs(int level, Queue<Node> queue, int target, int currCost, Stack<Integer> currStack, int minCost) {
        if (currCost > target || currCost + minCost > target) return null;
        if (currCost == target) return currStack;

        Queue<Node> next = new PriorityQueue<>((a, b) -> a.cost == b.cost ? b.digit - a.digit : a.cost - b.cost);
        next.addAll(queue);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (currCost + node.cost > target) continue;
            currStack.push(node.digit);
            Stack<Integer> res = dfs(level + 1, next, target, currCost + node.cost, currStack, minCost);
            if (res == null) currStack.pop();
            else return res;
        }
        return null;
    }

    class Node {
        int cost, digit;

        public Node(int cost, int digit) {
            this.cost = cost;
            this.digit = digit;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "cost=" + cost +
                    ", digit=" + digit +
                    '}';
        }
    }

    public static void main(String[] args) {
        Contest4_II contest = new Contest4_II();
        {
            int[] costs = {4, 3, 2, 5, 6, 7, 2, 5, 5};
            int target = 9;
            String res = contest.largestNumber(costs, target);
            System.out.println(res);
        }
    }
}
