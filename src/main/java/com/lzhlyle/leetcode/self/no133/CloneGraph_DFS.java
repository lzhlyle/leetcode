package com.lzhlyle.leetcode.self.no133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph_DFS {
    // dfs
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, copy(node));
        dfs(node, map);
        return map.get(node.val);
    }

    private void dfs(Node nd, Map<Integer, Node> map) {
        Node copied = map.get(nd.val);
        if (copied.neighbors.size() > 0) return;
        for (Node nb : nd.neighbors) {
            if (!map.containsKey(nb.val))
                map.put(nb.val, copy(nb));
            copied.neighbors.add(map.get(nb.val));
            dfs(nb, map);
        }
    }

    private Node copy(Node ori) {
        return new Node(ori.val, new ArrayList<>(ori.neighbors.size()));
    }
}
