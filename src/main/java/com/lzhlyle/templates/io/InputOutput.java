package com.lzhlyle.templates.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            {
                // int: 1
                int i = scanner.nextInt();
                System.out.println(i);
            }

            {
                // String: "hello world"
                String str = scanner.nextLine();
                System.out.println(str);
            }

            {
                // List<Integer>: [1,2,3,4,5]
                String[] values = scanner.nextLine()
                        .replace("[", "")
                        .replace("]", "")
                        .split(",");
                List<Integer> list = new ArrayList<>(values.length);
                for (String v : values) {
                    if (v.isEmpty()) continue;
                    list.add(Integer.valueOf(v));
                }
                System.out.println(list);
            }

            {
                // int[]: [1,2,3,4,5]
                String[] values = getValues(scanner.nextLine());
                int[] arr = new int[values.length];
                int i = 0;
                for (String v : values) {
                    arr[i++] = Integer.parseInt(v);
                }
                System.out.println(Arrays.toString(arr));
            }

            {
                // char[]: ["a","b","c"]
                String[] values = getValues(scanner.nextLine());
                char[] arr = new char[values.length];
                int i = 0;
                for (String v : values) {
                    arr[i++] = v.charAt(0);
                }
                System.out.println(Arrays.toString(arr));
            }

            {
                // String[]: ["abc","def","ghi"]
                String[] arr = getValues(scanner.nextLine());
                System.out.println(Arrays.toString(arr));
            }

            {
                // TreeNode: [1,2,null,3] // 层次遍历
                String[] values = getValues(scanner.nextLine());
                // TODO lzh
                System.out.println();
            }

            {
                // Node: [1,2,3,4,5]
                String[] values = getValues(scanner.nextLine());

            }

            {
                // DbNode: [1,2,3,4,5]
                String[] values = getValues(scanner.nextLine());

            }
        }
    }

    private static void buildTreeNode(TreeNode root, int value) {
        if (value < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(value);
                System.out.println(root.val);
            } else buildTreeNode(root.left, value);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(value);
                System.out.println(root.val);
            } else buildTreeNode(root.right, value);
        }
    }

    private static String[] getValues(String line) {
        return line.replace("[", "")
                .replace("]", "")
                .split(",");
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    static class DbNode {
        int val;
        DbNode prev, next;

        public DbNode(int val) {
            this.val = val;
            prev = next = null;
        }
    }
}
