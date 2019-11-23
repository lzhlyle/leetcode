package com.lzhlyle.templates.algorithm;

import java.util.*;

public class DFS {
    Set<Object> visited = new HashSet<>();

    /**
     * 深度优先 - 递归
     *
     * @param node
     */
    public void dfsWithRecursion(Object node) {
        // terminator
        if (visited.contains(node)) return;

        // process
        this._process(node);
        visited.add(node);

        // drill down
        for (Object child : this._getChildren(node)) {
            this.dfsWithRecursion(child);
        }

        // reverse state
    }

    /**
     * 深度优先 - 栈
     *
     * @param node
     */
    public void dfsWithStack(Object node) {
        Stack<Object> stack = new Stack<>();
        stack.push(node);

        // terminator
        while (!stack.isEmpty()) {
            Object n = stack.pop();
            if (visited.contains(n)) continue;
            visited.add(n);

            // process
            this._process(n);

            // drill down
            for (Object child : this._getChildren(n)) {
                stack.push(child);
            }

            // reverse stats
        }

    }

    private List<Object> _getChildren(Object node) {
        return Collections.emptyList();
    }

    private void _process(Object node) {
    }
}
