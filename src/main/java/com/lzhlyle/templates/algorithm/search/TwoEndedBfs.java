package com.lzhlyle.templates.algorithm.search;

import java.util.*;

/**
 * 双向广度优先搜索
 */
public class TwoEndedBfs {
    /**
     * 双向广度优先搜索 - 循环
     *
     * @param beginNode
     * @param endNode
     */
    public void twoEndedBfsWithQueue(Object beginNode, Object endNode) {
        Set<Object> meets = new HashSet<>(); // nodes that may meet, will be given usually
        Queue<Object> beginQueue = new LinkedList<>(Collections.singleton(beginNode));
        Queue<Object> endQueue = new LinkedList<>(Collections.singleton(endNode));

        // terminator
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            // always from less to more
            if (beginQueue.size() > endQueue.size()) {
                Queue<Object> swap = beginQueue;
                beginQueue = endQueue;
                endQueue = swap;
            }

            Queue<Object> nextBegin = new LinkedList<>();
            meets.removeAll(beginQueue);
            while (!beginQueue.isEmpty()) {
                Object begin = beginQueue.remove();

                // process
                this._process(begin);

                List<Object> children = this._getChildren(begin);
                for (Object child : children) {
                    // pruning
                    if (!meets.contains(child)) continue;
                    if (endQueue.contains(child)) return; // meet, O(n) while looking up
                    nextBegin.add(child);
                }
            }

            // drill down
            beginQueue = nextBegin;

            // reverse state
        }
    }

    /**
     * 双向广度优先搜索 - 递归
     *
     * @param beginNode
     * @param endNode
     */
    public void twoEndedBfsWithRecursion(Object beginNode, Object endNode) {
        Set<Object> meets = new HashSet<>(); // nodes that may meet, will be given usually
        Set<Object> beginSet = new HashSet<>(Collections.singleton(beginNode));
        Set<Object> endSet = new HashSet<>(Collections.singleton(endNode));

        this.bfs(0, beginSet, endSet, meets);
    }

    // bfs recursion
    private int bfs(int level, Set<Object> beginSet, Set<Object> endSet, Set<Object> meets) {
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
        meets.removeAll(beginSet);
        for (Object begin : beginSet) {
            // process
            this._process(begin);

            List<Object> children = this._getChildren(begin);
            for (Object child : children) {
                // pruning
                if (!meets.contains(child)) continue;
                if (endSet.contains(child)) return level; // meet, O(1)
                nextBegin.add(child);
            }
        }

        // drill down
        return this.bfs(level, nextBegin, endSet, meets);

        // reverse state
    }

    private List<Object> _getChildren(Object node) {
        return Collections.emptyList();
    }

    private void _process(Object node) {
    }
}
