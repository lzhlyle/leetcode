package com.lzhlyle.leetcode.recite.no297;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree_Recursion {
    private static final String _SPLITER = ",";
    private static final String _NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        _buildString(root, sb);
        return sb.toString();
    }

    private void _buildString(TreeNode node, StringBuilder sb) {
        if (node == null) sb.append(_NULL).append(_SPLITER);
        else {
            sb.append(node.val).append(_SPLITER);
            _buildString(node.left, sb);
            _buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(_SPLITER)));
        return _buildTree(nodes);
    }

    private TreeNode _buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(_NULL)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = _buildTree(nodes);
        node.right = _buildTree(nodes);
        return node;
    }
}
