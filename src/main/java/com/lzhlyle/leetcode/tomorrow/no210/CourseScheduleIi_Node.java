package com.lzhlyle.leetcode.tomorrow.no210;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleIi_Node {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // construct graph with nodes
        Node[] arr = new Node[numCourses];
        for (int i = 0; i < numCourses; i++)
            arr[i] = new Node(i);
        for (int[] p : prerequisites) {
            int to = p[0], from = p[1];
            arr[from].tos.add(arr[to]);
            arr[to].in++;
        }

        // bfs: from in == 0 to tos list
        Queue<Node> queue = new LinkedList<>();
        for (Node node : arr)
            if (node.in == 0)
                queue.add(node);
        if (queue.isEmpty()) return new int[0];

        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            Set<Node> next = new HashSet<>();
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                res[i++] = node.val;
                for (Node to : node.tos) {
                    to.in--;
                    if (to.in == 0)
                        next.add(to);
                }
            }
            queue = new LinkedList<>(next);
        }

        // check
        if (i != numCourses) return new int[0];
        return res;
    }

    class Node {
        int val, in;
        Set<Node> tos;

        Node(int val) {
            this.val = val;
            in = 0;
            tos = new HashSet<>();
        }
    }
}
