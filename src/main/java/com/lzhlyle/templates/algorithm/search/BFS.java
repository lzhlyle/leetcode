package com.lzhlyle.templates.algorithm.search;

import java.util.*;

/**
 * 广度优先
 */
public class BFS {
    Set<Object> visited = new HashSet<>();

    public void bfs(Object node) {
        Queue<Object> queue = new LinkedList<>();
        queue.add(node);

        // terminator
        while (!queue.isEmpty()) {
            Object n = queue.remove();
            if (visited.contains(n)) continue;
            visited.add(n);

            // process
            this._process(n);

            // drill down
            queue.addAll(this._getChildren(n));

            // reverse state
        }
    }

    private List<Object> _getChildren(Object node) {
        return Collections.emptyList();
    }

    private void _process(Object node) {
    }
}
