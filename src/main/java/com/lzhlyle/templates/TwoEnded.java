package com.lzhlyle.templates;

import java.util.*;

public class TwoEnded {
    public void twoEndedBfsWithQueue(Object beginNode, Object endNode) {
        Set<Object> visited = new HashSet<>();

        Queue<Object> beginQueue = new LinkedList<>();
        beginQueue.add(beginNode);

        Queue<Object> endQueue = new LinkedList<>();
        endQueue.add(endNode);

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
                if (visited.contains(begin)) return; // meet
                visited.add(begin);

                // process
                this._process(begin);

                nextBegin.addAll(this._getChildren(begin));
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
