package com.lzhlyle.templates.algorithm;

import java.util.*;

/**
 * 双向广度优先搜索
 */
public class TwoEndedBfs {
    /**
     * 双向广度优先搜索 - 循环 (使用入队时标记，可改为出队时标记)
     *
     * @param beginNode
     * @param endNode
     */
    public void twoEndedBfsWithQueue(Object beginNode, Object endNode) {
        Set<Object> visited = new HashSet<>();

        Queue<Object> beginQueue = new LinkedList<>();
        beginQueue.add(beginNode);
        visited.add(beginNode); // 也可在出队后visited.add()

        Queue<Object> endQueue = new LinkedList<>();
        endQueue.add(endNode);
        visited.add(endNode);

        // terminator
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            // always from less to more
            if (beginQueue.size() > endQueue.size()) {
                Queue<Object> swap = beginQueue;
                beginQueue = endQueue;
                endQueue = swap;
            }

            Queue<Object> nextBegin = new LinkedList<>();
            while (!beginQueue.isEmpty()) {
                Object begin = beginQueue.remove();

                // 出队时标记已访问
                // if (visited.contains(begin)) return; // meet;
                // visited.add(begin);

                // process
                this._process(begin);

                List<Object> children = this._getChildren(begin);
                for (Object child : children) {
                    // 入队时标记已访问
                    if (visited.contains(child)) return; // meet;

                    // pruning..

                    nextBegin.add(child);
                    visited.add(child);
                }
            }

            // drill down
            beginQueue = nextBegin;

            // reverse state
        }
    }

    /**
     * 双向广度优先搜索 - 递归 (使用出队时标记，可改为入队时标记)
     *
     * @param beginNode
     * @param endNode
     */
    public void twoEndedBfsWithRecursion(Object beginNode, Object endNode) {
        Set<Object> visited = new HashSet<>();

        Set<Object> beginSet = new HashSet<>();
        beginSet.add(beginNode);
        // visited.add(beginNode);

        Set<Object> endSet = new HashSet<>();
        endSet.add(endNode);
        // visited.add(endNode);

        this.bfs(0, beginSet, endSet, visited);
    }

    // bfs recursion
    private int bfs(int level, Set<Object> beginSet, Set<Object> endSet, Set<Object> visited) {
        // terminator
        if (beginSet.size() == 0 || endSet.size() == 0) return -1; // cannot find

        // process
        level++;
        // always from less to more
        if (beginSet.size() > endSet.size()) {
            Set<Object> swap = beginSet;
            beginSet = endSet;
            endSet = swap;
        }
        Set<Object> nextBegin = new HashSet<>();
        for (Object begin : beginSet) {
            if (visited.contains(begin)) return level; // meet

            // 使用时标记~出队时标记
            visited.add(begin);

            List<Object> children = this._getChildren(begin);
            // pruning..
            nextBegin.addAll(children);
        }

        // drill down
        return this.bfs(level, nextBegin, endSet, visited);

        // reverse state
    }

    private List<Object> _getChildren(Object node) {
        return Collections.emptyList();
    }

    private void _process(Object node) {
    }
}
