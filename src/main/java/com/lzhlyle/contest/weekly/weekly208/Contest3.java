package com.lzhlyle.contest.weekly.weekly208;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Contest3 {
    private List<String> list;
    private Node root;
    private Map<String, Node> map;
    private boolean oper;

    public Contest3(String kingName) {
        root = new Node(kingName);
        map = new HashMap<>();
        map.put(kingName, root);
        oper = true;
    }

    public void birth(String parentName, String childName) {
        Node parent = map.get(parentName);
        Node child = new Node(childName);
        map.put(childName, child);
        parent.children.add(child);
        oper = true;
    }

    public void death(String name) {
        Node person = map.get(name);
        person.death();
        oper = true;
    }

    public List<String> getInheritanceOrder() {
        if (!oper) return list;
        oper = false;
        list = new LinkedList<>();
        dfs(root);
        return list;
    }

    // dfs: pre-order
    private void dfs(Node node) {
        if (node == null) return;
        if (node.alive) list.add(node.name);
        for (Node child : node.children) {
            dfs(child);
        }
    }

    class Node {
        String name;
        List<Node> children;
        boolean alive;

        Node(String name) {
            this.name = name;
            children = new LinkedList<>();
            alive = true;
        }

        void death() {
            alive = false;
        }
    }
}
