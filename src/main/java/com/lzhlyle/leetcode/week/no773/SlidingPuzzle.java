package com.lzhlyle.leetcode.week.no773;

import java.util.*;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] beginBoard) {
        int[][] endBoard = new int[][]{{1, 2, 3}, {4, 5, 0}};
        byte[] begin = new byte[6], end = new byte[6];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                begin[beginBoard[i][j]] = end[endBoard[i][j]] = (byte) (1 << (5 - (i * 3) - j));
            }
        }

        long beginCompress = compress(begin), endCompress = compress(end);
        if (beginCompress == endCompress) return 0;

        Set<byte[]> beginSet = new HashSet<>(Collections.singleton(begin));
        Set<byte[]> endSet = new HashSet<>(Collections.singleton(end));

        Set<Long> visited = new HashSet<>(Arrays.asList(beginCompress, endCompress));
        Set<Long> beginVisited = new HashSet<>(Collections.singleton(beginCompress));
        Set<Long> endVisited = new HashSet<>(Collections.singleton(endCompress));

        return bfs(0, beginSet, endSet, beginVisited, endVisited, visited);
    }

    private int bfs(int step, Set<byte[]> beginSet, Set<byte[]> endSet, Set<Long> beginVisited, Set<Long> endVisited, Set<Long> visited) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return -1;

        step++;
        if (beginSet.size() > endSet.size()) {
            Set<byte[]> swap = beginSet;
            beginSet = endSet;
            endSet = swap;

            Set<Long> swapVisited = beginVisited;
            beginVisited = endVisited;
            endVisited = swapVisited;
        }

        Set<byte[]> nextBegin = new HashSet<>();
        for (byte[] begin : beginSet) {
            List<byte[]> neighbors = getNeighbors(begin);
            for (byte[] neighbor : neighbors) {
                long compress = compress(neighbor);
                if (endVisited.contains(compress)) return step;
                if (visited.contains(compress)) continue;
                visited.add(compress);
                beginVisited.add(compress);
                nextBegin.add(neighbor);
            }
        }

        return bfs(step, nextBegin, endSet, beginVisited, endVisited, visited);
    }

    private List<byte[]> getNeighbors(byte[] board) {
        List<byte[]> res = new LinkedList<>();
        byte zero = board[0];
        // 32, 16, 8
        //  4,  2, 1
        if (zero < 8) res.add(swapPosition(board, zero, (byte) (zero << 3)));
        if (zero > 4) res.add(swapPosition(board, zero, (byte) (zero >> 3)));
        if (zero != 4 && zero != 32) res.add(swapPosition(board, zero, (byte) (zero << 1)));
        if (zero != 8 && zero != 1) res.add(swapPosition(board, zero, (byte) (zero >> 1)));
        return res;
    }

    private byte[] swapPosition(byte[] board, byte zero, byte block) {
        byte[] clone = board.clone();
        for (int i = 1; i < 6; i++) {
            if (clone[i] == block) {
                clone[i] = zero;
                clone[0] = block;
                break;
            }
        }
        return clone;
    }

    private long compress(byte[] board) {
        long res = 0b0L;
        for (int i = 0; i < 6; i++) {
            res |= board[i] << (6 * (6 - i - 1));
        }
        return res;
    }
}
