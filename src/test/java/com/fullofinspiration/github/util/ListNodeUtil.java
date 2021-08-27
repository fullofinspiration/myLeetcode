package com.fullofinspiration.github.util;

import com.fullofinspiration.github.tool.ListNode;
import com.sun.istack.internal.Nullable;


public class ListNodeUtil {
    public static ListNode buildListNode(int[] ints) {
        ListNode next = null;
        for (int i = ints.length - 1; i >= 0; i--) {
            next = new ListNode(ints[i], next);
        }
        return next;
    }

    public static boolean equal(@Nullable ListNode first, @Nullable ListNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            String msg = String.format("First data: %s or second data: %s is null!", first, second);
            System.out.println(msg);
            return false;
        }
        if (first.getVal() != second.getVal()) {
            String format = String.format("First value: %s is not equal to second value: %s", first.getVal(), second.getVal());
            System.out.println(format);
            return false;
        }
        return equal(first.next, second.next);
    }
}
