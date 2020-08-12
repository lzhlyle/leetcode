package com.lzhlyle.leetcode.self.no133;

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
        Node res = new Node(node.val, new ArrayList<>());
        map.put(node, res);
        for (Node n : node.neighbors)
            res.neighbors.add(dfs(n, map));
        return res;
    }
}
