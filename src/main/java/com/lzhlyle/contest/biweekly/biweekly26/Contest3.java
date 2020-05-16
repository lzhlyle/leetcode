package com.lzhlyle.contest.biweekly.biweekly26;

public class Contest3 {
    // 上面的都大于等于我
    private int cnt;

    public int goodNodes(TreeNode root) {
        cnt = 0;
        dfs(root, root.val);
        return cnt;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            cnt++;
            // System.out.println(node.val);
        }
        dfs(node.left, Math.max(max, node.val));
        dfs(node.right, Math.max(max, node.val));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
