package com.lzhlyle.templates.algorithm;

import java.util.*;

/**
 * 双向广度优先搜索
 */
public class TwoEndedBfs {
    /**
     * 双向广度优先搜索 (入队时标记、出队时标记)
     *
     * @param beginNode
     * @param endNode
     */
    public void twoEndedBfs(Object beginNode, Object endNode) {
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
                Queue<Object> swap = endQueue;
                endQueue = beginQueue;
                beginQueue = swap;
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

    private List<Object> _getChildren(Object node) {
        return Collections.emptyList();
    }

    private void _process(Object node) {
    }
}
