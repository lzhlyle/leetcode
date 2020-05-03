package com.lzhlyle.contest.weekly.weekly183;

import java.util.LinkedList;
import java.util.Queue;

public class Contest3_III {
    // bfs
    public String longestDiverseString(int a, int b, int c) {
        String res = "";
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("", a, b, c));
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.remove();
                res = node.val;
                if (node.a > 0) {
                    if (node.val.length() < 2 || !node.val.substring(node.val.length() - 2).equals("aa"))
                        queue.add(new Node(node.val + "a", node.a - 1, node.b, node.c));
                }
                if (node.b > 0) {
                    if (node.val.length() < 2 || !node.val.substring(node.val.length() - 2).equals("bb"))
                        queue.add(new Node(node.val + "b", node.a, node.b - 1, node.c));
                }
                if (node.c > 0) {
                    if (node.val.length() < 2 || !node.val.substring(node.val.length() - 2).equals("cc"))
                        queue.add(new Node(node.val + "c", node.a, node.b, node.c - 1));
                }
            }
        }
        return res;
    }

    class Node {
        String val;
        int a, b, c;

        Node(String val, int a, int b, int c) {
            this.val = val;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Contest3_III contest = new Contest3_III();
        {
            int a = 4, b = 42, c = 7;
            String res = contest.longestDiverseString(a, b, c);
            System.out.println(res);
        }
    }
}
