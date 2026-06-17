package org.Nodes;

public class Node {
    public final int hash;
    public final int key;
    public Object value;
    public Node next;
    public Node prev;

    public Node(int hash, int key, Object value, Node next, Node prev) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
