package com.lzhlyle.contest.weekly177;

public class Contest2 {
    private int[] parents;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] visited = new boolean[n];
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = -1;
        boolean res = dfs(0, leftChild, rightChild, visited);
        for (int i = 1; i < n; i++) {
            if (parents[i] == -1) return false;
        }
        return res;
    }

    private boolean dfs(int i, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (visited[i]) return false;

        visited[i] = true;
        boolean l, r;
        if (leftChild[i] != -1) {
            parents[leftChild[i]] = i;
            l = dfs(leftChild[i], leftChild, rightChild, visited);
        } else l = true;
        if (rightChild[i] != -1) {
            parents[rightChild[i]] = i;
            r = dfs(rightChild[i], leftChild, rightChild, visited);
        } else r = true;

        return l && r;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int n = 4;
            int[] leftChild = new int[]{1, -1, 3, -1}, rightChild = new int[]{2, -1, -1, -1};
            boolean res = contest.validateBinaryTreeNodes(n, leftChild, rightChild);
            System.out.println(res);
        }
        {
            int n = 4;
            int[] leftChild = new int[]{1, -1, 3, -1}, rightChild = new int[]{2, 3, -1, -1};
            boolean res = contest.validateBinaryTreeNodes(n, leftChild, rightChild);
            System.out.println(res);
        }
        {
            int n = 2;
            int[] leftChild = new int[]{1, 0}, rightChild = new int[]{-1, -1};
            boolean res = contest.validateBinaryTreeNodes(n, leftChild, rightChild);
            System.out.println(res);
        }
        {
            int n = 6;
            int[] leftChild = new int[]{1, -1, -1, 4, -1, -1}, rightChild = new int[]{2, -1, -1, 5, -1, -1};
            boolean res = contest.validateBinaryTreeNodes(n, leftChild, rightChild);
            System.out.println(res);
        }
    }
}
