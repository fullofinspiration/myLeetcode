package com.fullofinspiration.github.util;

import com.fullofinspiration.github.tool.ListNode;

public class ListNodeUtil {
    public static ListNode buildListNode(int[] ints) {
        ListNode next = null;
        for (int i = ints.length - 1; i >= 0; i--) {
            next = new ListNode(ints[i], next);
        }
        return next;
    }
}
