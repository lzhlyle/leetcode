package com.lzhlyle.leetcode.recite.no773;

import java.util.*;

public class SlidingPuzzle_BFS {
    public int slidingPuzzle(int[][] beginBoard) {
        // define end board
        int[][] endBoard = new int[][]{{1, 2, 3}, {4, 5, 0}};
        // initial byte-boards
        byte[] begin = new byte[6], end = new byte[6]; // byte 8b
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                begin[beginBoard[i][j]] = (byte) (1 << (5 - (i * 3) - j));
                end[endBoard[i][j]] = (byte) (1 << (5 - (i * 3) - j));
            }
        }

        long beginCompressing = compress(begin);
        long target = compress(end);
        if (beginCompressing == target) return 0;

        Set<byte[]> beginSet = new HashSet<>(Collections.singleton(begin));
        Set<Long> visited = new HashSet<>(Collections.singleton(beginCompressing));
        return bfs(0, beginSet, target, visited);
    }

    private int bfs(int step, Set<byte[]> beginSet, long target, Set<Long> visited) {
        if (beginSet.isEmpty()) return -1;

        step++;
        Set<byte[]> nextBegin = new HashSet<>();
        for (byte[] begin : beginSet) {
            List<byte[]> possibilities = getPossibilities(begin);
            for (byte[] possibility : possibilities) {
                long compressing = compress(possibility);
                if (target == compressing) return step;
                if (visited.contains(compressing)) continue;
                visited.add(compressing);
                nextBegin.add(possibility);
            }
        }

        return bfs(step, nextBegin, target, visited);
    }

    private long compress(byte[] board) {
        long res = 0b0;
        for (int i = 1; i < 6; i++) {
            res |= board[i] << (6 * (6 - i - 1)); // 拼成一行
        }
        return res;
    }

    private List<byte[]> getPossibilities(byte[] board) {
        List<byte[]> res = new LinkedList<>();
        // 只需要移动第0号
        // 32, 16, 8
        //  4,  2, 1
        byte zero = board[0];
        // up << 3
        if ((zero << 3) <= (1 << 5)) {
            res.add(swapPosition(board, zero, (byte) (zero << 3)));
        }
        // down >> 3
        if ((zero >> 3) > 0) {
            res.add(swapPosition(board, zero, (byte) (zero >> 3)));
        }
        // left << 1
        if (zero != (1 << 2) && zero != (1 << 5)) {
            res.add(swapPosition(board, zero, (byte) (zero << 1)));
        }
        // right >> 1
        if (zero != 1 && zero != (1 << 3)) {
            res.add(swapPosition(board, zero, (byte) (zero >> 1)));
        }

        return res;
    }

    private byte[] swapPosition(byte[] board, byte zero, byte neighbor) {
        byte[] clone = board.clone();
        for (int i = 1; i < 6; i++) {
            if (clone[i] == neighbor) {
                clone[i] = zero;
                clone[0] = neighbor;
                break;
            }
        }
        return clone;
    }
}
