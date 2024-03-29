package com.fullofinspiration.github.tool;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            '}';
    }
}
