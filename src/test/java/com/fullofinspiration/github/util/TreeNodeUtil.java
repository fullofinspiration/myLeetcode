package com.fullofinspiration.github.util;

import com.fullofinspiration.github.tool.TreeNode;
import com.sun.istack.internal.Nullable;

public class TreeNodeUtil {
    public static boolean equal(@Nullable TreeNode first, @Nullable TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            String msg = String.format("First or second is null!, first: %s, second: %s", first, second);
            System.out.println(msg);
            return false;
        }
        if (first.val != second.val) {
            String msg = String.format("First val: %s is not equal to second value: %s", first.val, second.val);
            System.out.println(msg);
            return false;
        }
        return equal(first.left, second.left) && equal(first.right, second.right);
    }
}
