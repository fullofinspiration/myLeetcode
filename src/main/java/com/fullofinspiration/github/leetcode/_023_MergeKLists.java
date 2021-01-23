package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 值得注意的是n个链表排序而不是两个链表排序，
 * 这里先写两个链表排序方法，然后写n个链表排序，
 * 里面又嵌套了两个出口，也就是调用mergeTwoLists方法相当于也是一个递归方法，
 * 这个方式好奇特，以前从没有遇到过
 */
public class _023_MergeKLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode preNode = null, head = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (preNode == null && head == null) {
                    preNode = l1;
                    head = l1;
                } else {
                    preNode.next = l1;
                    preNode = l1;
                }

                l1 = l1.next;
            } else {
                if (preNode == null && head == null) {
                    preNode = l2;
                    head = l2;
                } else {
                    preNode.next = l2;
                    preNode = l2;
                }

                l2 = l2.next;
            }
        }
        if (l1 == null)
            preNode.next = l2;
        if (l2 == null)
            preNode.next = l1;
        return head;
    }

    public ListNode mergeKLists1(List<ListNode> listNodes) {
        if (listNodes.isEmpty())
            return null;
        if (listNodes.size() == 1)
            return listNodes.get(0);
        if (listNodes.size() == 2)
            return mergeTwoLists(listNodes.get(0), listNodes.get(1));
        return mergeTwoLists(mergeKLists1(listNodes.subList(0, listNodes.size() / 2)),
                mergeKLists1(listNodes.subList(listNodes.size() / 2, listNodes.size())));
    }
    public ListNode mergeKLists (ListNode[] listNodes) {
        return mergeKLists1(Arrays.asList(listNodes));
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        l1.next = l4;
        l4.next = l7;
        l2.next = l5;
        l5.next = l8;
        l3.next = l6;
        l6.next = l9;
        List<ListNode> listNodes = new LinkedList<>();
        listNodes.add(l1);
        listNodes.add(l2);
        listNodes.add(l3);
        _023_MergeKLists l = new _023_MergeKLists();
        ListNode listNode = l.mergeKLists1(listNodes);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
