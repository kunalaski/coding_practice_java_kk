package org.easy.designhashset;

import org.Nodes.Node;

public class MyHashSet {

    Node[] bucket = new Node[DEFAULT_INITIAL_CAPACITY];
    static final int DEFAULT_INITIAL_CAPACITY = 10 << 4; // aka 16
    private static final Object PRESENT = new Object();

    public MyHashSet() {

    }

    public void add(int key) {

        int hash = hash(key);
        int i = hash & DEFAULT_INITIAL_CAPACITY-1;
        Node node = bucket[i];
        if(node == null) {
            node = new Node(hash, key, PRESENT, null, null);
            bucket[i] = node;
        } else {
            while (node.next != null) {
                if(node.key == key) return;
                node = node.next;
            }
            node.next = node.key == key? null: new Node(hash, key, PRESENT, null, node);
        }

    }

    public void remove(int key) {
        int hash = hash(key);
        int i = hash & DEFAULT_INITIAL_CAPACITY-1;
        Node node = bucket[i];

        while (node != null) {
            if(node.key == key) {
                if(node.prev == null) {
                    bucket[i] = node.next;
                    if(node.next != null) node.next.prev = null;
                } else {
                    Node prevNode = node.prev;
                    if(node.next == null) prevNode.next = null;
                    else {
                        prevNode.next = node.next;
                        node.next.prev = prevNode;
                    }
                }
                node.next = null;
                node.prev = null;
                break;
            }
            node = node.next;
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        int i = hash & DEFAULT_INITIAL_CAPACITY-1;
        Node node = bucket[i];
        while (node != null) {
            if(node.key == key) return true;
            node = node.next;
        }
        return false;
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
