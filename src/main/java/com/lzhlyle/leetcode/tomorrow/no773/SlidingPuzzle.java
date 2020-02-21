package com.lzhlyle.leetcode.tomorrow.no773;

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

        long beginCompressing = compress(begin), endCompressing = compress(end);
        if (beginCompressing == endCompressing) return 0;

        Set<byte[]> beginSet = new HashSet<>(Collections.singleton(begin));
        Set<byte[]> endSet = new HashSet<>(Collections.singleton(end));

        Set<Long> visited = new HashSet<>(Arrays.asList(beginCompressing, endCompressing));
        Set<Long> beginVisited = new HashSet<>(Collections.singleton(beginCompressing));
        Set<Long> endVisited = new HashSet<>(Collections.singleton(endCompressing));

        return twoEndedBFS(0, beginSet, endSet, visited, beginVisited, endVisited);
    }

    private int twoEndedBFS(int step, Set<byte[]> beginSet, Set<byte[]> endSet,
                            Set<Long> visited, Set<Long> beginVisited, Set<Long> endVisited) {
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
            List<byte[]> possibilities = getPossibilities(begin);
            for (byte[] possibility : possibilities) {
                long compressing = compress(possibility);
                if (endVisited.contains(compressing)) return step;
                if (visited.contains(compressing)) continue;
                visited.add(compressing);
                beginVisited.add(compressing);
                nextBegin.add(possibility);
            }
        }

        return twoEndedBFS(step, nextBegin, endSet, visited, beginVisited, endVisited);
    }

    private List<byte[]> getPossibilities(byte[] board) {
        List<byte[]> res = new LinkedList<>();
        byte zero = board[0];
        // 32, 16, 8
        // 4, 2, 1
        if ((zero << 3) <= 32) res.add(swapPosition(board, zero, (byte) (zero << 3))); // up << 3
        if ((zero >> 3) >= 1) res.add(swapPosition(board, zero, (byte) (zero >> 3))); // down >> 3
        if (zero != 32 && zero != 4) res.add(swapPosition(board, zero, (byte) (zero << 1))); // left << 1
        if (zero != 8 && zero != 1) res.add(swapPosition(board, zero, (byte) (zero >> 1))); // right >> 1
        return res;
    }

    private byte[] swapPosition(byte[] board, byte zero, byte num) {
        byte[] clone = board.clone();
        for (int i = 1; i < 6; i++) {
            if (clone[i] == num) {
                clone[i] = zero;
                clone[0] = num;
                break;
            }
        }
        return clone;
    }

    private long compress(byte[] board) {
        long res = 0b0;
        for (int i = 1; i < 6; i++) {
            res |= board[i] << (6 * (6 - i - 1));
        }
        return res;
    }
}
