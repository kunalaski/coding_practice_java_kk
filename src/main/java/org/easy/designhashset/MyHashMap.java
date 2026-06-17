package org.easy.designhashset;

import org.Nodes.Node;

public class MyHashMap {

    Node[] bucket;
    static final int DEFAULT_INITIAL_CAPACITY = 10 << 4;

    public MyHashMap() {
        bucket = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    public void put(int key, int value) {

        int hash = hash(key);
        int i = hash & DEFAULT_INITIAL_CAPACITY-1;
        Node node = bucket[i];
        if(node == null) {
            node = new Node(hash, key, value, null, null);
            bucket[i] = node;
        } else {
            while (node.next != null) {
                if(node.key == key) {
                    break;
                }
                node = node.next;
            }
            if(node.key == key) {
                node.value = value;
            } else {
                node.next = new Node(hash, key, value, null, node);
            }

        }

    }

    public int get(int key) {
        int hash = hash(key);
        int i = hash & DEFAULT_INITIAL_CAPACITY-1;
        Node node = bucket[i];
        while (node != null) {
            if(node.key == key) return (int) node.value;
            node = node.next;
        }
        return -1;
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
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
