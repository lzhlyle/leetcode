package com.lzhlyle.leetcode.tomorrow.no22;

import java.util.*;

public class GenerateParentheses_bfs {
    // bfs
    public List<String> generateParenthesis(int n) {
        if (n < 1) return Collections.emptyList();
        if (n == 1) return Collections.singletonList("()");

        List<String> result = new ArrayList<>();

        Queue<GPNode> queue = new LinkedList<>();
        queue.add(new GPNode("(", 1));

        while (!queue.isEmpty()) {
            GPNode node = queue.remove();
            if (node.curr.length() >= (n << 1)) {
                result.add(node.curr);
                continue;
            }
            if (node.leftCnt < n) queue.add(new GPNode(node.curr + "(", node.leftCnt + 1));
            if (node.curr.length() < (node.leftCnt << 1)) queue.add(new GPNode(node.curr + ")", node.leftCnt));
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> res = new GenerateParentheses_bfs().generateParenthesis(3);
        System.out.println(Arrays.toString(res.toArray()));
    }
}

class GPNode {
    String curr;
    int leftCnt;

    public GPNode(String curr, int leftCnt) {
        this.curr = curr;
        this.leftCnt = leftCnt;
    }
}