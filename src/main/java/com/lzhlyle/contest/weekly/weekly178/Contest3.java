package com.lzhlyle.contest.weekly.weekly178;

public class Contest3 {
    // 递归
    private int expected = 0, headVal;
    private ListNode headNode;

    public boolean isSubPath(ListNode head, TreeNode root) {
        headVal = head.val;
        headNode = head;
        ListNode curr = head;
        while (curr != null) {
            expected++;
            curr = curr.next;
        }

        return isSubPath(head, root, 0);
    }

    private boolean isSubPath(ListNode head, TreeNode root, int match) {
        if (head == null) return match == expected;
        if (root == null) return false;

        if (head.val == root.val) { // 当前值相同
            if (head.val == headVal) {
                // 当前值与开头相同
                // 可从头开始
                if (match > 0) {
                    if (isSubPath(headNode, root, 0)) return true;
                }

                // 不从头开始
                if (isSubPath(head.next, root.left, match + 1)) return true;
                if (isSubPath(head.next, root.right, match + 1)) return true;
            } else {
                // 当前值与开头不同，无法重新开始，必须继续
                if (isSubPath(head.next, root.left, match + 1)) return true;
                if (isSubPath(head.next, root.right, match + 1)) return true;
            }
        } else { // 当前值不同，清空已匹配的
//            if (head.val == headVal) {
//                // 当前值与开头相同
//                // 可从头开始
//                if (match > 0) {
//                    if (isSubPath(headNode, root, 0)) return true;
//                }
//            }

            if (isSubPath(headNode, root.left, 0)) return true;
            if (isSubPath(headNode, root.right, 0)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(10);

            TreeNode root = new TreeNode(1);
            TreeNode n1 = new TreeNode(1);
            root.right = n1;
            TreeNode n2 = new TreeNode(10);
            n1.left = n2;
            n1.right = new TreeNode(1);
            n2.left = new TreeNode(9);

            boolean res = contest.isSubPath(head, root);
            System.out.println(res);
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}
