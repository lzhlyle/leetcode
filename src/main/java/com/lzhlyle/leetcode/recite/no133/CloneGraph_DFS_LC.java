package com.lzhlyle.leetcode.recite.no133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph_DFS_LC {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for (Node n : node.neighbors)
            clone.neighbors.add(dfs(n, map));
        return clone;
    }
}
