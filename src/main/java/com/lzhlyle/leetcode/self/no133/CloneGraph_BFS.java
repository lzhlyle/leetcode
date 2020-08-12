package com.lzhlyle.leetcode.self.no133;

import java.util.*;

public class CloneGraph_BFS {
    // bfs
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, copy(node));
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node nd = queue.remove();
            Node copied = map.get(nd.val);
            for (Node nb : nd.neighbors) {
                if (!map.containsKey(nb.val)) {
                    map.put(nb.val, copy(nb));
                    queue.add(nb);
                }
                copied.neighbors.add(map.get(nb.val));
            }
        }
        return map.get(node.val);
    }

    private Node copy(Node ori) {
        return new Node(ori.val, new ArrayList<>(ori.neighbors.size()));
    }
}
