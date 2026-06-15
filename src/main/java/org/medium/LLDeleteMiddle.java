package org.medium;

import org.Nodes.ListNode;

//2095. Delete the Middle Node of a Linked List
//You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
//
//The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
//
//For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

public class LLDeleteMiddle {
    public static ListNode deleteMiddle(ListNode head) {

        if(head.next == null) return null;

        ListNode rabbit = head.next;
        ListNode tortoise = head;
        int pnt = 2;
        while(rabbit.next != null) {
            rabbit = rabbit.next;
            pnt++;
            if(pnt%2 == 0) {
                tortoise = tortoise.next;
            }
        }

        tortoise.next = tortoise.next.next;
        return head;

    }

    static ListNode buildList(int... vals) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int v : vals) cur = cur.next = new ListNode(v);
        return dummy.next;
    }

    static int[] toArray(ListNode head) {
        int size = 0;
        for (ListNode n = head; n != null; n = n.next) size++;
        int[] res = new int[size];
        for (int i = 0; i < size; i++, head = head.next) res[i] = head.val;
        return res;
    }

    public static void main(String[] args) {
        assert java.util.Arrays.equals(toArray(deleteMiddle(buildList(1,3,4,7,1,2,6))), new int[]{1,3,4,1,2,6});
        assert java.util.Arrays.equals(toArray(deleteMiddle(buildList(1,2,3,4))), new int[]{1,2,4});
        assert java.util.Arrays.equals(toArray(deleteMiddle(buildList(2,1))), new int[]{2});
        assert deleteMiddle(buildList(1)) == null;
        System.out.println("All tests passed!");
    }
}
